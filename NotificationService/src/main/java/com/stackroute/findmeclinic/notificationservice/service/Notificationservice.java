package com.stackroute.findmeclinic.notificationservice.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


import com.stackroute.findmeclinic.notificationservice.model.Notification;
import com.stackroute.findmeclinic.notificationservice.repo.NotificationRepo;
@Service
public class Notificationservice {

  NotificationRepo notifyRepo;
   SimpMessagingTemplate messageTemplate;
   @Autowired
   public Notificationservice(SimpMessagingTemplate messageTemplate,NotificationRepo notifyRepo ) {
       this.messageTemplate=messageTemplate;
       this.notifyRepo=notifyRepo;
   }

   public boolean  sendNotification(Notification notification) {

   //HttpHeaders headers = new HttpHeaders();
       int count=0;
   boolean flag=true;
   List<Notification> notificationList = new ArrayList<>();
   notificationList = notifyRepo.findAll();
   count = notificationList.size();
//     Notification notif = restTemplate.getForObject("http://localhost/api/v1/appointment", Notification.class);
   if(notification!=null) {

       System.out.println("id "+count+1);
       notification.setNotifgenDate(new Date());
       notifyRepo.save(notification);
        messageTemplate.convertAndSend("/topic/greetings", notification);
   }
   else
   {
       flag=false;
   }


    return flag;

   }


   public List<Notification> getPatientNotification(String email)
   {

       System.out.println("Hiiiii");

       Notification notify = new Notification();
       List<Notification> patientNotify = new ArrayList<>();
       List<Notification> notificationList = new ArrayList<>();
       notificationList = notifyRepo.findAll();
       Iterator<Notification> iterator = notificationList.iterator();
       while(iterator.hasNext())

   {
           notify = iterator.next();
           if(email.equals(notify.getPatientId()))
                   {
               patientNotify.add(notify);
                   }
   }


   return patientNotify;
   }


   public List<Notification> getDoctorNotification(String email)
   {

       System.out.println("Hiiiii");

       Notification notify = new Notification();
       List<Notification> doctorNotify = new ArrayList<>();
       List<Notification> notificationList = new ArrayList<>();
       notificationList = notifyRepo.findAll();
       Iterator<Notification> iterator = notificationList.iterator();
       while(iterator.hasNext())

   {
           notify = iterator.next();
           if(email.equals(notify.getDoctorId()))
                   {
               doctorNotify.add(notify);
                   }
   }


   return doctorNotify;
   }


}
