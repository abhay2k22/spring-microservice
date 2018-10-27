# spring-microservice
Spring boot Calculator microservice

Add, Minus, Mul and Div are independent microserivce which is based on SRP principal. They do only specific operation. 

All four microservice register themselves with Eureak registry server (i.e.eurekaserver).

calculatorAPIGateWay build using zuul framework to act as APIGateway. This is only configured as router.

calculator is a client which is calling all microservice based on client-side-discovery (i.e. CalculatorController) and server-side-discovry (i.e. CalculatorControllerWithGateway)
