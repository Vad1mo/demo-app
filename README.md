# Openshift Liberty Profile Demo app

Simple demo application demonstrating distributed session with WebSphere Liberty Profile  on OpenShift/Kubernetes

## Run

```
gradle build libertyStart
```


## References
[Ression persistence for the Liberty profile][1]


[1]: https://www.ibm.com/support/knowledgecenter/SSRTLW_9.0.0/com.ibm.websphere.wlp.nd.multiplatform.doc/ae/twlp_admin_session_persistence.html


## Demo
`for ((i=1;i<=100;i++)); do curl localhost:9080/myLibertyApp/rest && echo "\n" && sleep 2 ;done `
