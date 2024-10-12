### Comprehensive Demo: Multi-Service Quarkus Application with Kustomize, OpenShift Dev Spaces, and ArgoCD

#### **Objective:**
Showcase how to create, configure, and deploy multiple Quarkus microservices using Kustomize for configuration management, OpenShift Dev Spaces for development, and ArgoCD for continuous delivery.

### Optional: 
* Fork Repo into personal repo
  * Update 

#### **Demo Steps:**
## Building the Applications

### For `service-a`

1. **Navigate to the `service-a` directory:**
   ```sh
   cd service-a
   ```

2. **Build the application:**
   ```sh
   ./mvnw clean package -Dnative
   ```

3. Login to Quay registry 
  ```sh
  docker login quay-registry-quay-quay-registry.apps.your-ocp4-cluster.com
  ```

4. **Build the Docker image:**
  ![20241012090915](https://i.imgur.com/UJgjwrl.png)
   ```sh
   docker build -t quay-registry-quay-quay-registry.apps.your-ocp4-cluster.com/service-a:latest .
   ```

5. **Push the Docker image to your registry:**
   ```sh
   docker push quay-registry-quay-quay-registry.apps.your-ocp4-cluster.com/service-a:latest
   ```

### For `service-b`

1. **Navigate to the `service-b` directory:**
   ```sh
   cd ../service-b
   ```

2. **Build the application:**
   ```sh
   ./mvnw clean package
   ```

3. **Build the Docker image:**
   ![20241012091450](https://i.imgur.com/ViemEOk.png)
   ```sh
   docker build -t quay-registry-quay-quay-registry.apps.your-ocp4-cluster.com/service-b:latest .
   ```

4. **Push the Docker image to your registry:**
   ```sh
   docker push quay-registry-quay-quay-registry.apps.your-ocp4-cluster.com/service-b:latest
   ```

## Testing the Applications Locally

### For `service-a`

1. **Run the application locally:**
   ```sh
   ./mvnw quarkus:dev
   ```

2. **Test the endpoint:**
   ```sh
   curl http://localhost:8080/quote/isaac-newton
   ```

### For `service-b`

1. **Run the application locally:**
   ```sh
   ./mvnw quarkus:dev
   ```

2. **Test the endpoint:**
   ```sh
   curl http://localhost:8080/hello
   ```

## Deploying the Applications Using Kustomize
### Update the following file 
```sh
$ cat cluster-config/service-a/patch-pull-secret-data.yaml
apiVersion: v1
kind: Secret
metadata:
  name: quay-pull-secret
  namespace: microservice-demo
data:
  .dockerconfigjson: CHANGEME
```

```sh 
$ cat cluster-config/service-a/patch-image.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: service-a
spec:
  template:
    spec:
      containers:
      - name: service-a
        image: quay-registry-quay-quay-registry.apps.cluster-xxxxx.xxxxx.sandbox0000.opentlc.com/user1/service-a
```

```sh
$ cat cluster-config/service-b/patch-image.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: service-b
spec:
  template:
    spec:
      containers:
      - name: service-b
        image: quay-registry-quay-quay-registry.apps.cluster-xxxxx.xxxxx.sandbox0000.opentlc.com/user1/service-b
```

### Example Deployment and Service for `service-a`
```sh 
# Test the configuration 
kustomize build cluster-config/service-a

# Deploy the configurtation 
 oc apply -k cluster-config/service-a
```

### Example Deployment and Service for `service-b`
```sh 
# Test the configuration 
kustomize build cluster-config/service-b

# Deploy the configurtation 
oc apply -k cluster-config/service-b
```

## Testing the Integration

Once the services are deployed, you can test the integration by accessing the endpoints of `service-a` and `service-b`.

### Testing service-a
```
$ curl -w '\n' https://$(oc get routes -n microservice-demo | grep service-a | awk '{print $2}')/quote/nikola-tesla
The present is theirs; the future, for which I have really worked, is mine. - Nikola Tesla
```

### Testing service-b
```
$ curl -w '\n' https://$(oc get routes -n microservice-demo | grep service-b | awk '{print $2}')/quote/sean-gerety
The technology you use impresses no one. The experience you create with it is everything. - Sean Gerety
```

# Bonus 
* Integrate the service with ArgoCD so it is integrated with the cluster deployment.