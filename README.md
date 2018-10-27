# spring-microservice
# Spring boot Calculator microservice
A very trival, simple calculator microservice demo application build using spring-boot. The sample application provides a client-side discovery using FeignClient and server-side discovery using Zuul API Gateway. 
This service also showcase example of circute breaker using hystrix and how to use/call fallback function.

# Source Code 
Add, Minus, Mul and Div are independent microserivce which is based on SRP principal. They do only specific operation. 

All four microservice register themselves with Eureak registry server (i.e.eurekaserver).

calculatorAPIGateWay build using zuul framework to act as APIGateway. This is only configured as router.

calculator is a client which is calling all microservice based on client-side-discovery (i.e. CalculatorController) and server-side-discovry (i.e. CalculatorControllerWithGateway)

# LICENSE
Copyright 2018 Abhay Goel

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
