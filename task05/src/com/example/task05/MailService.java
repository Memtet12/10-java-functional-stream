package com.example.task05;

import java.util.*;
import java.util.function.Consumer;


public class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>()
    {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(Sendable<T> mail) {
        mailBox.computeIfAbsent(mail.getTo(), k -> new ArrayList<>()).add(mail.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
