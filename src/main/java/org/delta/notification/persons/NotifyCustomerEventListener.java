package org.delta.notification.persons;

import com.google.common.eventbus.Subscribe;

import javax.inject.Singleton;

@Singleton
public class NotifyCustomerEventListener {

    @Subscribe
    public void notifyCustomerEvent(NotifyCustomerEvent notifyCustomerEvent) {
        System.out.println("Call event: " + notifyCustomerEvent.getNotificationData().getCustomerName());
    }

}
