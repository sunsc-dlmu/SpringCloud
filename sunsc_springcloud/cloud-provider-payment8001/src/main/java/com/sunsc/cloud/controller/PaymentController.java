package com.sunsc.cloud.controller;

import com.sunsc.cloud.entities.CommonResult;
import com.sunsc.cloud.entities.Payment;
import com.sunsc.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient; //对外暴露服务信息，可以通过该对象查到注册中心的服务信息

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***********插入结果：" + result);

        if(result > 0 ){
            return new CommonResult<Integer>(200, "插入成功" + serverPort, result);
        }else{
            return new CommonResult(444,"插入失败了");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("***********查找：" + result);
        if(result != null ){
            return new CommonResult<Payment>(200, "查找成功" + serverPort, result);
        }else{
            return new CommonResult(444,"查找失败，不存在该记录");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        for(String ele : list){
            log.info(ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance ele : instances){
            log.info(ele.getInstanceId() + ":::" + ele.getUri());
        }
        return this.discoveryClient;
    }

}
