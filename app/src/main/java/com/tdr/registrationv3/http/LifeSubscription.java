package com.tdr.registrationv3.http;

import rx.Subscription;

/**
 * Created by parry
 */


public interface LifeSubscription {
    void bindSubscription(Subscription subscription);
}

