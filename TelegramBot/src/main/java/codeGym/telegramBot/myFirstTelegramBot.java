package codeGym.telegramBot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static codeGym.telegramBot.telegramBotContent.*;


public class myFirstTelegramBot extends multiSessionTelegramBot {

    public static final String NAME = "kendrasvgBottie_Bot";

    public static final String TOKEN = ""; /*Se elimina antes de pushear*/

    public myFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {

        if (getMessageText().equals("/start")) {
            setUserGlory(0);

            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonkey().equals("step_1_btn")) {
            setUserGlory(20);

            sendTextMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of("¡Tomar una salchicha! +20 de fama", "step_2_btn", "¡Tomar un pescado! +20 de fama", "step_2_btn", "¡Tirar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonkey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Romper al robot aspiradora", "step_3_btn"));
        }

        if (getCallbackQueryButtonkey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of("Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn", "Huir del robot aspirador! +30 de fama", "step_4_btn", "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn"));
        }

        if(getCallbackQueryButtonkey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Ponerme GoPro y encenderla", "step_5_btn" ));
        }

        if(getCallbackQueryButtonkey().equals("step_5_btn")) {
            setUserGlory(40);
            sendTextMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of("Grabarte maullando Karaoke", "step_6_btn", "Grabarte durmiendo", "step_6_btn", "Grabarte haciendo parkour"
                    , "step_6_btn"));
        }

        if(getCallbackQueryButtonkey().equals("step_6_btn")) {
            setUserGlory(40);
            sendTextMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Hackear la contraseña de la computadora", "step_7_btn"));
        }

        if(getCallbackQueryButtonkey().equals("step_7_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Salir al patio", "step_8_btn"));
        }

        if(getCallbackQueryButtonkey().equals("step_8_btn")) {
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new myFirstTelegramBot());
    }
}
