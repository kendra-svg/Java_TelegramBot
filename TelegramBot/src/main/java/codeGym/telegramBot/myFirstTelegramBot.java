package codeGym.telegramBot;


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class myFirstTelegramBot extends multiSessionTelegramBot {

    public static final String NAME = "kendrasvgBottie_Bot";

    public static final String TOKEN = "6887330894:AAHh3QblVwZY2F3A3CFC3wGfuh5gANSrykM";

    public myFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {


        //Aca va la funcionalidad principal del bot
        sendTextMessageAsync("Hola futura programadora Kendra!");
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new myFirstTelegramBot());
    }
}