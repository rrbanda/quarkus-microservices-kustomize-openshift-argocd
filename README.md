### Comprehensive Demo: Multi-Service Quarkus Application with Kustomize, OpenShift Dev Spaces, and ArgoCD

#### **Objective:**
Showcase how to create, configure, and deploy multiple Quarkus microservices using Kustomize for configuration management, OpenShift Dev Spaces for development, and ArgoCD for continuous delivery.

#### **Demo Steps:**

1. **Setup the Environment:**
   - **Prerequisites:**
     - Access to an OpenShift cluster with Dev Spaces and ArgoCD enabled.
     - Install Quarkus CLI on your local machine.
     - Familiarize yourself with OpenShift CLI (`oc`), Kustomize CLI, and ArgoCD CLI.

2. **Create Multiple Quarkus Projects:**
   - Launch OpenShift Dev Spaces from the OpenShift console.
   - Create Quarkus services, e.g., `service-a` and `service-b`, using the Quarkus CLI:
     ```bash
     quarkus create app org.demo:service-a --resource=service-a
     quarkus create app org.demo:service-b --resource=service-b
     ```

3. **Explore, Build and Test the Applications:**
   - Navigate through each project to explain key files and directories.
   - Build and run the applications locally to verify they work:
     ```bash
     ./mvnw compile quarkus:dev
     ```

4. **Create Kustomize Configurations:**
   - In each service directory, create a `k8s` folder for Kubernetes manifests.
   - Create a base deployment YAML file and a Kustomization YAML file:
     ```yaml
     apiVersion: kustomize.config.k8s.io/v1beta1
     kind: Kustomization
     resources:
     - deployment.yaml
     ```

5. **Deploy to OpenShift:**
   - Use Kustomize to build and deploy configurations to OpenShift:
     ```bash
     kustomize build k8s | oc apply -f -
     ```

6. **Install and Configure ArgoCD:**
   - Install ArgoCD in your OpenShift cluster:
     ```bash
     kubectl create namespace argocd
     kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml
     ```
   - Configure ArgoCD to pull from your Git repository with Kustomize configurations:
     - Create an `Application` manifest for each service:
     ```yaml
     apiVersion: argoproj.io/v1alpha1
     kind: Application
     metadata:
       name: service-a
       namespace: argocd
     spec:
       destination:
         namespace: default
         server: https://kubernetes.default.svc
       source:
         path: k8s/service-a
         repoURL: 'https://github.com/your-repo/quarkus-multi-service'
         targetRevision: HEAD
       project: default
       syncPolicy:
         automated:
           prune: true
           selfHeal: true
         syncOptions:
         - CreateNamespace=true
     ```

7. **Demonstrate Continuous Deployment:**
   - Apply changes to the code or configurations and push them to Git.
   - Show how ArgoCD automatically detects changes and deploys them to OpenShift.

8. **Verify and Monitor Deployment:**
   - Use ArgoCD’s UI to verify that the applications are synchronized.
   - Access the service URLs to ensure they are running with updated configurations.
   - **List Endpoints:**
     - To list the endpoints (services) created in your OpenShift cluster, use the following command:
       ```bash
       oc get services
       ```
     - This command will display a list of services along with their names, types, cluster IPs, and ports.
   - Monitor logs and metrics via the OpenShift console.

9. **Showcase GitOps and ArgoCD Features:**
   - Demonstrate rollback by reverting changes in Git and observing ArgoCD perform the rollback.
   - Highlight ArgoCD’s visualization of application dependencies and health status.

10. **Clean-Up:**
    - Use ArgoCD to clean up applications:
     ```bash
     argocd app delete service-a
     argocd app delete service-b
     ```

#### **Technical Requirements:**
- **Access**: Ensure access to an OpenShift cluster and a Git repository with Kustomize configurations.
- **Tools**: Install necessary CLI tools (`oc`, `kustomize`, `quarkus`, `argocd`).
- **Internet Connection**: Stable connection for accessing and managing cloud resources.
