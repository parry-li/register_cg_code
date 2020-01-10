package com.tdr.registration.http;

import rx.Subscription;

/**
 * Created by parry
 */


public interface LifeSubscription {
    void bindSubscription(Subscription subscription);
}

