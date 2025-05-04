import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {
    /*
    1 = Для зарегистрировоного ниже лимита
     */
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService(); //Обьект

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    /*
    2 = Для зарегистрированого болше лимита
     */
    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService(); //Обьект

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500; //Ожидаем

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered); //Фактический результат

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }


    /*
    3 = Незарегистрированый проверяем границу 500
     */
    @Test
    void shouldBeCalculatedForUnregisteredAndTheLimit() {
        BonusService service = new BonusService(); //Обьект

        // подготавливаем данные:
        long amount = 50_000;
        boolean registered = false;
        long expected = 500; //Ожидаем

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered); //Фактический результат

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    /*
    4 = Проверяем незарегистрированый пользователь  болше границы 500
    */
    @Test
    void shouldBeCalculatedForUnregisteredAndOverTheLimit() {
        BonusService service = new BonusService(); //Обьект

        // подготавливаем данные:
        long amount = 50_100;
        boolean registered = false;
        long expected = 500; //Ожидаем

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered); //Фактический результат

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }


    /*
    5 = Для незарегистрировоного ниже лимита границы 500
     */
    @Test
    void shouldBeCalculatedForUnregisteredAndUnderTheLimit() {
        BonusService service = new BonusService(); //Обьект

        // подготавливаем данные:
        long amount = 49_990;
        boolean registered = false;
        long expected = 499; //Ожидаем

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered); //Фактический результат

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

}