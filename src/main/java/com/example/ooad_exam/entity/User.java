package com.example.ooad_exam.entity;

import jakarta.persistence.Entity;

/**
 * Ентіті яка буде містити усі основні дані про користувачів
 */
@Entity
public class User {

    /**
     * id,
     * isBlocked = false, (флаг блокування сервісу для користувача)*
     * email, (для сповіщення у разі вибору ручної оплати)
     * List<UserPayment> subscriptions = список усіх підписок на оплати користувача
     */
}
