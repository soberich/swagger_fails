package com.example.domain.enumeration;

import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Application constants.
 */
public interface Constants {

    String APPLICATION_NAME   = "swagger_fails-App";

    String LOGIN_REGEX        = "^[_.@A-Za-z0-9-]*$";
    String SITE_REGEX         = "^(http://www\\.|https://www\\.|http://|https://)?[a-z0-9]+([\\-.][a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(/.*)?$";
    String INN_REGEX          = "^[0-9]{10}$";
    // ISO3166-1 alpha-2
    String COUNTRY_CODE_REGEX = "^[A-Z]{2}$";
    String ZIP_REGEX          = "^[0-9]{6}$";
    String ALPHANUMERIC       = "^[A-Za-z0-9]+$";
    String PERIOD_PATTERN     = "^([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?$";
    String LOCALE_PATTERN     = "^[a-zA-Z]{2,8}_[a-zA-Z]{2}$";

    String   SYSTEM_ACCOUNT   = "system";
    String   ANONYMOUS_USER   = "anonymoususer";
    Locale   DEFAULT_LANGUAGE = Locale.forLanguageTag("ru");
    String   DEFAULT_ZONE     = "Europe/Moscow";
    ZoneId   DEFAULT_ZONEID   = ZoneId.of(DEFAULT_ZONE);
    TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone(DEFAULT_ZONE);

    String COMPANY_TITLE_RUS = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435\u0020\u043A\u043E\u043C\u043F\u0430\u043D\u0438\u0438";
    String LIMIT_RUS         = "\u041B\u0438\u043C\u0438\u0442";
    String INN_RUS           = "\u0418\u041D\u041D";
    String ADDRESS_SH_RUS    = "\u0410\u0434\u0440\u0435\u0441";
    String ADDRESS_RUS       = ADDRESS_SH_RUS + "\u0020\u0028\u043C\u043E\u0436\u043D\u043E\u0020\u0432\u043F\u0438\u0441\u0430\u0442\u044C\u0020\u0441\u044E\u0434\u0430\u0020\u043D\u0435\u0441\u0442\u0440\u0443\u043A\u0442\u0443\u0440\u0438\u0440\u043E\u0432\u0430\u043D\u043D\u0443\u044E\u0020\u0441\u0442\u0440\u043E\u0447\u043A\u0443\u0020\u0430\u0434\u0440\u0435\u0441\u0430\u002C\u0020\u0435\u0441\u043B\u0438\u0020\u043D\u0435\u0442\u0020\u0432\u043E\u0437\u043C\u043E\u0436\u043D\u043E\u0441\u0442\u0438\u0020\u043F\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u044C\u0020\u0435\u0451\u0020\u0432\u0020\u0432\u0438\u0434\u0435\u0020\u0440\u0430\u0437\u0431\u0438\u0435\u043D\u0438\u044F\u0020\u043F\u043E\u0020\u043F\u0440\u0435\u0434\u044B\u0434\u0443\u0449\u0438\u043C\u0020\u043A\u043E\u043B\u043E\u043D\u043A\u0430\u043C\u0029";
    String RATING            = "\u0420\u0435\u0439\u0442\u0438\u043D\u0433";
    String RATING_AVG        = "\u0421\u0443\u043C\u043C\u0430\u0440\u043D\u044B\u0439\u0020\u0440\u0435\u0439\u0442\u0438\u043D\u0433";
    String SCORING_RESULTS   = "\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442\u0020\u043E\u0431\u0440\u0430\u0431\u043E\u0442\u043A\u0438";

    String STATE_OR_REGION_RUS  = "\u041E\u0431\u043B\u0430\u0441\u0442\u044C\u002C\u0020\u0420\u0435\u0433\u0438\u043E\u043D";
    String TOWN_RUS             = "\u0413\u043E\u0440\u043E\u0434\u002C\u0020\u041D\u0430\u0441\u0435\u043B\u0451\u043D\u043D\u044B\u0439\u0020\u043F\u0443\u043D\u043A\u0442";
    String STREET_RUS           = "\u0423\u043B\u0438\u0446\u0430";
    String HOUSE_OFFICE_ETC_RUS = "\u041D\u043E\u043C\u0435\u0440\u0020\u0434\u043E\u043C\u0430\u002C\u0020\u043E\u0444\u0438\u0441\u0430\u0020\u0438\u0020\u0442.\u043F.";
    String COUNTRY_LOCALE_RUS   = "\u0421\u0442\u0440\u0430\u043D\u0430\u0020ISO3166-1\u0020alpha-2\u0020\u043A\u043E\u0434";
    String ZIP_RUS              = "\u041F\u043E\u0447\u0442\u043E\u0432\u044B\u0439\u0020\u0438\u043D\u0434\u0435\u043A\u0441";
}
