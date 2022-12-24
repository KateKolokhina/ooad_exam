package com.example.ooad_exam;

import com.example.ooad_exam.dto.SubscribeInfoDTO;
import com.example.ooad_exam.entity.User;
import com.example.ooad_exam.entity.UserPayment;
import com.example.ooad_exam.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Наш головний контролер та точка входу API.
 *
 * Всі вказані вхідні параметри відповідних ендпоінтів мають знаходитись у body запиту.
 */
@Controller
public class MainController {

    @Autowired
    private PaymentService paymentService;

    /* POST ендпоінт буде викликано коли юзер створює нову підписку на оплату*/
    public UserPayment subscribeOnPayment(SubscribeInfoDTO info){
        // викликаємо
        return paymentService.createNewSubscription(info);
    }

    /* POST ендпоінт буде викликано коли прийде час сплати певної підписки певного користувача
    *
    * В подальшому вхідні параметри можна замінити на List of {userId, paymentId},
    * якщо потрібно провести оплату одразу для багатьох користувачів,
    * для демонстрації обрано варіант з одним користувачем за виклик
    * */
    public boolean createReceipt(long userId, long paymentId){

        // викликаємо метод створення рахунку + намагаємось провести оплату(якщо вона автоматична)
        // в випадку якщо оплата не пройде нам повернеться false,
        // що стане маркером для викликаючого АПІ сервісу що "треба буде спробувати повторну оплату"
        return paymentService.createReceipt(userId, paymentId);
    }


    /* PUT ендпоінт буде викликано для змінення статусу оплати рахунку (наприклад для якого раніше була обрана "ручна оплата") */
    public void updateReceipt(long receiptId, LocalDateTime date, String status ){
        paymentService.updateReceipt(receiptId,date, status);
    }

    /**
     * - При перевищенні допустимої кількості несплачених рахунків протягом заданого часу
     *   відбувається блокування сервісу (для користувача)
     */

    /* не зрозуміло з умови вказановог вище пункту завдання,
        чи це буде автоматизована операція зі сторони нашого сервісу,
        або хтось вже буде аналізувати це і тільки давати нам список користувачів на блок.
        Припустимо, що це робота цілком для нашого сервісу (тоді це Schedule таска )
     */
    public List<User> checkUserBlock(LocalDateTime startDate, LocalDateTime endDate) {
        return paymentService.checkUserBlock(startDate,endDate);
    }

    /* PUT ендпоінт буде викликано для разблокування певного користувача */
    public void updateReceipt(LocalDateTime startDate, LocalDateTime endDate, long userId){
        paymentService.unblockUser(startDate, endDate, userId);
    }

}
