package com.example.ooad_exam.entity;

import jakarta.persistence.Entity;

/**
 * Ентіті яка буде містити усі основні дані про підписки на оплату
 */
@Entity
public class UserPayment {

    /**
     * id,
     * userId,
     * period = ENUM (month or year)
     * tariff = null or id of exist Tariff
     * paymentData = null or PaymentInfo reference
     * startDate = коли вперше користувач підписався на оплату
     * status = активна підписка чи ні (якщо користувач наприклад відмовиться від неї)
     */
}
