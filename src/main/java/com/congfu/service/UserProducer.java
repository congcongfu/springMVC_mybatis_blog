package com.congfu.service;

import com.congfu.model.User;

/**
 * ${TAGS}
 * &lt;PRE&gt;
 *
 * @author by congfu.
 * @Date 17/2/18
 * @return ${return_type}
 * @since v0.0.1
 */
public interface UserProducer {

    /**
     * send message to queue
     * @param queueKey
     * @param user
     */
    public void sendDataToQueue(String queueKey, User user);
}
