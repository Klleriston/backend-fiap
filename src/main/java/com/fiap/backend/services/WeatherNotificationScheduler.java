package com.fiap.backend.services;

import com.fiap.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherNotificationScheduler {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @Autowired
    private UserService userService;
    @Autowired
    private FcmService fcmService;

    @Scheduled(fixedRate = 18000000)
    public void checkWeatherAndNotify() {
        double currentTemperature = weatherService.getTemperature("Sao Paulo");

        if (currentTemperature > 23.0) {
            List<User> users = userService.getAllUsers();
            for (User user : users) {
                String message = "A temperatura atual em São Paulo é de " + currentTemperature + "°C. Não se esqueça de se manter hidratado!";
                weatherNotificationService.createWeatherNotification(currentTemperature, message, user.getId());

                String userFcmToken = user.getFcmToken();
                if (userFcmToken != null) {
                    fcmService.sendNotification(userFcmToken, "Alerta Climático", message);
                }
            }
        }
    }
}
