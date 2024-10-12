# Development Instructions

## Building the Applications

### For `service-a`

1. **Navigate to the `service-a` directory:**
   ```sh
   cd service-a
   ```

2. **Build the application:**
   ```sh
   ./mvnw clean package
   ```

3. Login to Quay registry 
  ```sh
  docker login quay-registry-quay-quay-registry.apps.cluster-hzjdg.hzjdg.sandbox2168.opentlc.com
  ```

4. **Build the Docker image:**

   ```sh
   docker build -t quay-registry-quay-quay-registry.apps.cluster-hzjdg.hzjdg.sandbox2168.opentlc.com/service-a:latest .
   ```

5. **Push the Docker image to your registry:**
   ```sh
   docker push quay-registry-quay-quay-registry.apps.cluster-hzjdg.hzjdg.sandbox2168.opentlc.com/service-a:latest
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
   ```sh
   docker build -t quay-registry-quay-quay-registry.apps.cluster-hzjdg.hzjdg.sandbox2168.opentlc.com/service-b:latest .
   ```

4. **Push the Docker image to your registry:**
   ```sh
   docker push yquay-registry-quay-quay-registry.apps.cluster-hzjdg.hzjdg.sandbox2168.opentlc.com/service-b:latest
   ```

## Testing the Applications Locally

### For `service-a`

1. **Run the application locally:**
   ```sh
   ./mvnw quarkus:dev
   ```

2. **Test the endpoint:**
   ```sh
   curl http://localhost:8080/hello
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

### Example Deployment and Service for `service-a`

Create a file named `service-a-deployment.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: service-a
  labels:
    app: service-a
spec:
  replicas: 1
  selector:
    matchLabels:
      app: service-a
  template:
    metadata:
      labels:
        app: service-a
    spec:
      containers:
      - name: service-a
        image: your-docker-registry/service-a:latest
        ports:
        - containerPort: 8080

---
apiVersion: v1
kind: Service
metadata:
  name: service-a
spec:
  selector:
    app: service-a
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
```

### Example Deployment and Service for `service-b`

Create a file named `service-b-deployment.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: service-b
  labels:
    app: service-b
spec:
  replicas: 1
  selector:
    matchLabels:
      app: service-b
  template:
    metadata:
      labels:
        app: service-b
    spec:
      containers:
      - name: service-b
        image: your-docker-registry/service-b:latest
        ports:
        - containerPort: 8080

---
apiVersion: v1
kind: Service
metadata:
  name: service-b
spec:
  selector:
    app: service-b
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
```

### Example `kustomization.yaml`

Create a file named `kustomization.yaml`:

```yaml
apiVersion: kustomize.config.k8s.io/v1beta1
kind: Kustomization

resources:
  - service-a-deployment.yaml
  - service-b-deployment.yaml

commonLabels:
  app: integration-test

namespace: integration-test
```

### Deploy the Services Using Kustomize

Deploy the services using the following command:

```sh
kubectl apply -k .
```

## Testing the Integration

Once the services are deployed, you can test the integration by accessing the endpoints of `service-a` and `service-b`.

### Example Test Script

You can create a simple test script to check if the services are up and running:

```sh
#!/bin/bash

# Get the service URLs
SERVICE_A_URL=$(kubectl get svc service-a -o jsonpath='{.spec.clusterIP}:{.spec.ports[0].port}')
SERVICE_B_URL=$(kubectl get svc service-b -o jsonpath='{.spec.clusterIP}:{.spec.ports[0].port}')

# Test service-a
echo "Testing service-a..."
curl http://$SERVICE_A_URL/hello

# Test service-b
echo "Testing service-b..."
curl http://$SERVICE_B_URL/hello
```

## Clean Up

After testing, you can clean up the resources using:

```sh
kubectl delete -k .
```
