# demo-kubesecrets-springboot

Prerequisitos 
- Instalar docker y Kubernetes
- Configurar Maven
- Tener la imagen en docker hub


## Pasos. 

1. Clonar el Repositorio
2. Crear los secretes `kubectl create secret generic dev-test-secrets --from-literal=username=devuserkube --from-literal=userpass=devpasskube`
3. Ejecutar los comando de maven `mvn clean package`
4. Crear la imagen de docker `docker build -t eaguerom/demo-secret .`
5. Probar la imagen localmente: `docker run -p 8080:8080 -e TEST_USER=user-param -e TEST_PASS=pass-param demo-secret`
6. Subir la imagen a Docker hub `docker push eaguerom/demo-secret`
7. Aplicar la imagen para crear el pod `kubectl apply -f demo.yaml`

## Otros comandos: 

- Revisar los pods `kubectl get all`
- describir los pods `kubectl describe pod/`
- Ver la estructura del secret `kubectl get secret dev-test-secrets -o yaml`

Resultado:
```apiVersion: v1
data:
  username: ZGV2dXNlcmt1YmU=
  userpass: ZGV2cGFzc2t1YmU=
kind: Secret
metadata:
  creationTimestamp: "2020-08-11T16:51:05Z"
  name: dev-test-secrets
  namespace: default
  resourceVersion: "583792"
  selfLink: /api/v1/namespaces/default/secrets/dev-test-secrets
  uid: 93729dc6-9748-4026-9f86-9972b3635194
type: Opaque
```
