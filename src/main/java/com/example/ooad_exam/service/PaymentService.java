package com.example.ooad_exam.service;

import com.example.ooad_exam.dto.SubscribeInfoDTO;
import com.example.ooad_exam.entity.User;
import com.example.ooad_exam.entity.UserPayment;
import com.example.ooad_exam.repository.PaymentInfoRepository;
import com.example.ooad_exam.repository.ReceiptRepository;
import com.example.ooad_exam.repository.TariffRepository;
import com.example.ooad_exam.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    //константа що задає допустиму кількість несплачених рахунків
    private final int PERMISSIBLE_NUMBER_OF_UNPAID_RECEIPTS = 5;

    @Autowired
    private UserPaymentRepository userPaymentRepository;
    @Autowired
    private TariffRepository tariffRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;
    @Autowired
    private ReceiptRepository receiptRepository;

    /* виконуємо потрібну логіку для реєстрації нової підписки на оплату*/
    public UserPayment createNewSubscription(SubscribeInfoDTO info){
        // 1. Створюємо нового користувача\ знаходимо існуючого (через репозиторій)
        // 2. Перевіряємо наявність тарифу (через репозиторій)
        // 3. Реєструємо у базі нові платіжні дані користувача (PaymentInfo), якщо потрібно
        // 4. Створюємо новий UserPayment і зберігаємо його у базі

        // 5. повертаємо  створений UserPayment назовні

        // !! якщо на якомусь з пунктів буде помилка, прокидуємо її наверх +  відкатуємо усі викликані зміни у базі
            // throw new Exception(...)

        return null;
    }

    /* Створюємо рахунок і намагаємось провести автоматичну оплату.
    *  Якщо була обрана ручна оплата - цей рахунок просто буде надіслано користувачу на вказаний раніше імейл
    *
    * Метод поверне false якщо автоматична оплата не пройде, помилку якщо під час виконання щось піде не так,
    * true у інших випадках
    *  */
    public boolean createReceipt(long userId, long paymentId) {
//
//        !!! перед пунктами нижче перевіряємо наявність доступу до сервісу для користувача через його поле (isBlocked)

        // 1. Знаходимо існуючого користувача та інформацію про його підписку на оплату(через репозиторій)
        // User user, UserPayment paymentInfo.
        // 2. Створюємо відповідний новий Receipt зі статусом = "waiting for payment"

        // 3. if(paymentInfo. paymentData = null ) {
                    // відправляємо на імейл користувача створений рахунок
                    // return true; або кидаємо помилку якщо при відправці щось пішло не так
//            }
//            else if(paymentInfo. paymentData != null ) {
//                        намагаємось провести оплату за вказаними даними:
//                         boolean result =  call on paymentServiceApi
//                  якщо result = true ->
//                                          відправляємо сповіщення на імейл;
//                                          зберігаємо рахуном зі статусом - Accepted і датою оплати;
//                                          закінчуємо метод і повертаємо true;
//                       result = false ->
//                                          відправляємо сповіщення на імейл про надібність оформлення платіжних даних
//                                           і те що оплата не пройшла;
//                                          зберігаємо рахуном зі статусом - Declined і датою непрошедшої оплати;
//                                          закінчуємо метод і повертаємо false;

        // !! якщо на якомусь з пунктів буде помилка, прокидуємо її наверх +  відкатуємо усі викликані зміни у базі
        // throw new Exception(...)

        return true;
    }

    /* метод  для змінення статусу оплати рахунку, (наприклад для якого раніше була обрана "ручна оплата") */
    public void updateReceipt(long receiptId, LocalDateTime date,  String status) {
        // 1. Перевіряємо наявність рахунку через репозиторій
        // 2. оновлюємо статус і зазначаємо дату
        // 3. зберігаємо зміни

        // !! якщо на якомусь з пунктів буде помилка, прокидуємо її наверх +  відкатуємо усі викликані зміни у базі
        // throw new Exception(...)
    }

    /**
     * - При перевищенні допустимої кількості несплачених рахунків протягом заданого часу
     *   відбувається блокування сервісу (для користувача)
     */

     /* не зрозуміло з умови вказановог вище пункту завдання,
        чи це буде автоматизована операція зі сторони нашого сервісу,
        або хтось вже буде аналізувати це і тільки давати нам список користувачів на блок.
        Припустимо, що це робота цілком для нашого сервісу
     */
    public List<User> checkUserBlock(LocalDateTime startDate, LocalDateTime endDate) {
 //        1. Перевіряємо коректність вхідних даних
//         2. Шукаємо усі несплачені рахунки за даний період (через репозиторій receipt)
//         3. групуємо їх за користувачами і підраховуємо для кожного користувача їх кількість
//         4. фільтруємо отриману мапу за умовою count > PERMISSIBLE_NUMBER_OF_UNPAID_RECEIPTS
//         5. Оновлюємо флаг доступу у користувачів що залишились (isBlocked = true) і зберігаємо зміни у БД

        // 6. Повертаємо список користувачів для кого доступ заблоковано

        // !! якщо на якомусь з пунктів буде помилка, прокидуємо її наверх +  відкатуємо усі викликані зміни у базі
        // throw new Exception(...)

        return null;
    }

    /* метод для разблокування доступу вказаному користувачу. */
    public void unblockUser(LocalDateTime startDate, LocalDateTime endDate, long userId) {
        // 1. double-check що умова для розблокування виконана
        //      (кількість несплачених рахунків у вказані дати у цього користувача менша константи)

        // 2. Оновлюємо флаг доступу у користувача (isBlocked = false) і зберігаємо зміни у БД

        // !! якщо на якомусь з пунктів буде помилка, прокидуємо її наверх +  відкатуємо усі викликані зміни у базі
        // throw new Exception(...)
    }
}
