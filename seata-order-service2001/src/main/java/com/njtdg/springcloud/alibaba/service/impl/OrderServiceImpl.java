package com.njtdg.springcloud.alibaba.service.impl;

import com.njtdg.springcloud.alibaba.dao.OrderDao;
import com.njtdg.springcloud.alibaba.domain.Order;
import com.njtdg.springcloud.alibaba.service.AccountService;
import com.njtdg.springcloud.alibaba.service.OrderService;
import com.njtdg.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("------>开始新建订单");
        orderDao.create(order);

        log.info("------>订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------>订单微服务开始调用库存，做扣减end");

        log.info("------>订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------>订单微服务开始调用账户，做扣减end");

        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");
    }
}
