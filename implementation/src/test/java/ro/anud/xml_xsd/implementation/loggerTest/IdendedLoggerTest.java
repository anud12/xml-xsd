package ro.anud.xml_xsd.implementation.loggerTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.anud.xml_xsd.implementation.util.logging.LogScope;

import static ro.anud.xml_xsd.implementation.util.logging.LogScope.logScope;

@SpringBootTest(classes = IndentedLoggerTest.class)
class IndentedLoggerTest {

    @Test
    void testScopeLoggingWithExtendedBusinessFlow() {
        try (LogScope scope = logScope()) {
            OrderService orderService = new OrderService();
            orderService.processOrder("ORD-456");
        }
    }

    class OrderService {
        void processOrder(String orderId) {
            try (LogScope scope = LogScope.logScope("Extracting fromPerson")) {
                scope.log("OrderService: Start processing order " + orderId);
                OrderValidator validator = new OrderValidator();
                scope.log("OrderService: Validator created");
                if (validator.validate(orderId)) {
                    scope.log("OrderService: Order is valid");
                    OrderCalculator calculator = new OrderCalculator();
                    scope.log("OrderService: Calculator created");
                    double total = calculator.calculate(orderId, 5);
                    scope.log("OrderService: Total calculated: " + total);
                    DiscountService discountService = new DiscountService();
                    scope.log("OrderService: DiscountService created");
                    double discountedTotal = discountService.applyDiscount(orderId, total);
                    scope.log("OrderService: Discounted total: " + discountedTotal);
                    PaymentService paymentService = new PaymentService();
                    scope.log("OrderService: PaymentService created");
                    boolean paymentSuccess = paymentService.processPayment(orderId, discountedTotal);
                    scope.log("OrderService: Payment success: " + paymentSuccess);
                    if (paymentSuccess) {
                        OrderRepository repository = new OrderRepository();
                        scope.log("OrderService: Repository created");
                        repository.save(orderId, discountedTotal);
                        scope.log("OrderService: Order saved");
                    }
                } else {
                    scope.log("OrderService: Invalid order " + orderId);
                }
                scope.log("OrderService: End processing order " + orderId);
            }
        }
    }

    class OrderValidator {
        boolean validate(String orderId) {
            try (LogScope scope = logScope()) {
                scope.log("OrderValidator: Validating order " + orderId);
                boolean result = orderId.startsWith("ORD");
                scope.logReturn(result);
                return result;
            }
        }
    }

    class OrderCalculator {
        double calculate(String orderId, int itemCount) {
            try (LogScope scope = logScope()) {
                scope.log("OrderCalculator: Calculating total for " + orderId);
                double total = itemCount * 19.99;
                scope.logReturn(total);
                return total;
            }
        }
    }

    class DiscountService {
        double applyDiscount(String orderId, double total) {
            try (LogScope scope = logScope()) {
                scope.log("DiscountService: Checking discount for " + orderId);
                double discounted = total > 50 ? total * 0.9 : total;
                scope.logReturn(discounted);
                return discounted;
            }
        }
    }

    class PaymentService {
        boolean processPayment(String orderId, double amount) {
            try (LogScope scope = logScope()) {
                scope.log("PaymentService: Processing payment for " + orderId);
                boolean success = amount < 1000;
                scope.logReturn(success);
                return success;
            }
        }
    }

    class OrderRepository {
        void save(String orderId, double total) {
            try (LogScope scope = logScope()) {
                scope.log("OrderRepository: Saving order " + orderId);
                // Simulate save
                scope.log("OrderRepository: Order " + orderId + " saved with total $" + total);
            }
        }
    }

    @Test
    void testScopeLoggingWithMultithreading() throws InterruptedException {
        int threadCount = 3;
        Thread[] threads = new Thread[threadCount];
        String[] orderIds = {"ORD-100", "ORD-200", "ORD-300"};

        for (int i = 0; i < threadCount; i++) {
            final String orderId = orderIds[i];
            threads[i] = new Thread(() -> {
                try (LogScope scope = logScope()) {
                    OrderService orderService = new OrderService();
                    orderService.processOrder(orderId);
                }
            }, "OrderThread-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        // Optionally, assert log output if capturing System.out
    }
}