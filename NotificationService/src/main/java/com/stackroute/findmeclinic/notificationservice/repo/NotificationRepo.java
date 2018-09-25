package com.stackroute.findmeclinic.notificationservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.findmeclinic.notificationservice.model.Notification;


@Repository
public interface NotificationRepo extends MongoRepository<Notification,String>{

}
