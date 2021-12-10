package com.example.verbum.business.report;

import android.content.Context;
import android.os.Environment;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.FileUtils;
import com.google.android.material.internal.ContextUtils;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GenerateHTMLReport extends GenerateReports{
    File file;
    String content = "";

    public GenerateHTMLReport(Context context){
        super(context);
        dest = "Report.html";
    }

    @Override
    public void generateFile() throws Exception {

        settings();
        body();
        createFile();

        FileUtils.openFile(context, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()+"/"+dest));
    }

    @Override
    public void createFile() throws Exception {
        //file = new ObjectOutputStream(new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString(), dest)));

        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),dest);
        if(!file.exists()){
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
        writer.write(content);
        writer.close();

    }

    @Override
    public void settings() throws Exception {
        content += "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\n" +
                "        <!--==================== UNICONS ====================-->\n" +
                "        <link rel=\"stylesheet\" href=\"https://unicons.iconscout.com/release/v4.0.0/css/line.css\">\n" +
                "        \n" +
                "        <!--==================== SWIPER CSS ====================-->\n" +
                "        <link rel=\"stylesheet\" href=\"\">\n" +
                "        \n" +
                "        <!--==================== CSS ====================-->\n" +
                "        <style>"+
                "/*==================== GOOGLE FONTS ====================*/\n" +
                "@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');\n" +
                "\n" +
                "/*==================== VARIABLES CSS ====================*/\n" +
                ":root {\n" +
                "    --header-height: 3rem;\n" +
                "\n" +
                "    /*========== Colors ==========*/\n" +
                "    /* Change favorite color */\n" +
                "    --hue-color: 230; /*Purple 250 - Green 142 - Blue 230 - Pink 340*/\n" +
                "\n" +
                "    /* HSL color mode */\n" +
                "    --first-color: hsl(var(--hue-color), 100%, 52%);\n" +
                "    --first-color-second: hsl(var(--hue-color), 90%, 62%);\n" +
                "    --first-color-alt: hsl(var(--hue-color), 87%, 83%);\n" +
                "    --first-color-lighter: hsl(var(--hue-color), 100%, 82%);\n" +
                "    --title-color: hsl(var(--hue-color), 100%, 52%);\n" +
                "    --text-color: hsl(var(--hue-color), 20%, 12%);\n" +
                "    --text-color-light: hsl(var(--hue-color), 20%, 75%);\n" +
                "    --input-color: hsl(var(--hue-color), 70%, 90%);\n" +
                "    --body-color: hsl(var(--hue-color), 60%, 99%);\n" +
                "    --container-color: #FFF;\n" +
                "\n" +
                "    /*========== Font and typography ==========*/\n" +
                "    --body-font: 'Poppins', sans-serif;\n" +
                "\n" +
                "    /* .5rem = 8px, 1rem = 16px, 1.5rem = 24px ... */\n" +
                "    --big-font-size: 2rem;\n" +
                "    --h1-font-size: 1.5rem;\n" +
                "    --h2-font-size: 1.25rem;\n" +
                "    --h3-font-size: 1.125rem;\n" +
                "    --normal-font-size: .938rem;\n" +
                "    --small-font-size: .813rem;\n" +
                "    --smaller-font-size: .75rem;\n" +
                "\n" +
                "    /*========== Font weight ==========*/\n" +
                "    --font-medium: 500;\n" +
                "    --font-semi-bold: 600;\n" +
                "\n" +
                "    /*========== Margenes Bottom ==========*/\n" +
                "    /* .25rem = 4px, .5rem = 8px, .75rem = 12px ... */\n" +
                "    --mb-0-25: .25rem;\n" +
                "    --mb-0-5: .5rem;\n" +
                "    --mb-0-75: .75rem;\n" +
                "    --mb-1: 1rem;\n" +
                "    --mb-1-5: 1.5rem;\n" +
                "    --mb-2: 2rem;\n" +
                "    --mb-2-5: 2.5rem;\n" +
                "    --mb-3: 3rem;\n" +
                "\n" +
                "    /*========== z index ==========*/\n" +
                "    --z-tooltip: 10;\n" +
                "    --z-fixed: 100;\n" +
                "    --z-modal: 1000;\n" +
                "}\n" +
                "\n" +
                "/* Font size for large devices */\n" +
                "@media screen and (min-width: 968px) {\n" +
                "    :root {\n" +
                "        --big-font-size: 3rem;\n" +
                "        --h1-font-size: 2.25rem;\n" +
                "        --h2-font-size: 1.5rem;\n" +
                "        --h3-font-size: 1.25rem;\n" +
                "        --normal-font-size: 1rem;\n" +
                "        --small-font-size: .875rem;\n" +
                "        --smaller-font-size: .813rem;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "/*========== Variables Dark theme ==========*/\n" +
                "body.dark-theme{\n" +
                "    /* HSL color mode */\n" +
                "    --first-color-second: hsl(var(--hue-color), 30%, 8%);\n" +
                "    --title-color: hsl(var(--hue-color), 8%, 92%);\n" +
                "    --text-color: hsl(var(--hue-color), 8%, 72%);\n" +
                "    --input-color: hsl(var(--hue-color), 29%, 16%);\n" +
                "    --body-color: hsl(var(--hue-color), 28%, 12%);\n" +
                "    --container-color: hsl(var(--hue-color), 29%, 16%);\n" +
                "}\n" +
                "\n" +
                "/*========== Button Dark/Light ==========*/\n" +
                ".nav__btns{\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                ".change-theme{\n" +
                "    font-size: 1.25rem;\n" +
                "    color: var(--title-color);\n" +
                "    margin-right: var(--mb-1);\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                "\n" +
                ".change-theme:hover{\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "/*==================== BASE ====================*/\n" +
                "*{\n" +
                "    box-sizing: border-box;\n" +
                "    padding: 0;\n" +
                "    margin: 0;\n" +
                "}\n" +
                "\n" +
                "html{\n" +
                "    scroll-behavior: smooth;\n" +
                "}\n" +
                "\n" +
                "body{\n" +
                "    margin: 0 0 var(--header-height) 0;\n" +
                "    font-family: var(--body-font);\n" +
                "    font-size: var(--normal-font-size);\n" +
                "    background-color: var(--body-color);\n" +
                "    color: var(--text-color);\n" +
                "}\n" +
                "\n" +
                "h1,h2,h3,h4{\n" +
                "    color: var(--title-color);\n" +
                "    font-weight: var(--font-semi-bold);\n" +
                "}\n" +
                "\n" +
                "ul{\n" +
                "    list-style: none;\n" +
                "}\n" +
                "\n" +
                "a{\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "img{\n" +
                "    max-width: 100%;\n" +
                "    height: auto;\n" +
                "}\n" +
                "\n" +
                "/*==================== REUSABLE CSS CLASSES ====================*/\n" +
                ".section{\n" +
                "    padding: 2rem 0 4rem;\n" +
                "}\n" +
                "\n" +
                ".section__title{\n" +
                "    font-size: var(--h1-font-size);\n" +
                "}\n" +
                "\n" +
                ".section__subtitle{\n" +
                "    display: block;\n" +
                "    font-size: var(--small-font-size);\n" +
                "    margin-bottom: var(--mb-3);\n" +
                "}\n" +
                "\n" +
                ".section__title,\n" +
                ".section__subtitle{\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                "/*==================== LAYOUT ====================*/\n" +
                ".container{\n" +
                "    max-width: 768px;\n" +
                "    margin-left: var(--mb-1-5);\n" +
                "    margin-right: var(--mb-1-5);\n" +
                "}\n" +
                "\n" +
                ".grid{\n" +
                "    display: grid;\n" +
                "    gap: 1.5rem;\n" +
                "}\n" +
                "\n" +
                ".header{\n" +
                "    width: 100%;\n" +
                "    position: fixed;\n" +
                "    bottom: 0;\n" +
                "    left: 0;\n" +
                "    z-index: var(--z-fixed);\n" +
                "    background-color: var(--body-color);\n" +
                "}\n" +
                "\n" +
                "/*==================== NAV ====================*/\n" +
                ".nav{\n" +
                "    max-width: 968px;\n" +
                "    height: var(--header-height);\n" +
                "    display: flex;\n" +
                "    justify-content: space-between;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                ".nav__logo,\n" +
                ".nav__toggle{\n" +
                "    color: var(--title-color);\n" +
                "    font-weight: var(--font-medium);\n" +
                "}\n" +
                "\n" +
                ".nav__logo:hover{\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                ".nav__toggle{\n" +
                "    font-size: 1.1rem;\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                "\n" +
                ".nav__toggle:hover{\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                "@media screen and (max-width: 767px){\n" +
                "    .nav__menu{\n" +
                "        position: fixed;\n" +
                "        bottom: -100%;\n" +
                "        left: 0;\n" +
                "        width: 100%;\n" +
                "        background-color: var(--body-color);\n" +
                "        padding: 2rem 1.5rem 4rem;\n" +
                "        box-shadow: 0 -1px 4px rgba(0, 0, 0, .15);\n" +
                "        border-radius: 1.5rem 1.5rem 0 0;\n" +
                "        transition: .3s;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                ".nav__list{\n" +
                "    grid-template-columns: repeat(3, 1fr);\n" +
                "    gap: 2rem;\n" +
                "}\n" +
                "\n" +
                ".nav__link{\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;\n" +
                "    font-size: var(--small-font-size);\n" +
                "    color: var(--title-color);\n" +
                "    font-weight: var(--font-medium);\n" +
                "}\n" +
                "\n" +
                ".nav__link:hover{\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                ".nav__icon{\n" +
                "    font-size: 1.2rem;\n" +
                "}\n" +
                "\n" +
                ".nav__close{\n" +
                "    position: absolute;\n" +
                "    right: 1.3rem;\n" +
                "    bottom: .5rem;\n" +
                "    font-size: 1.5rem;\n" +
                "    cursor: pointer;\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                ".nav__close:hover{\n" +
                "    color: var(--first-color-alt);\n" +
                "}\n" +
                "/* show menu */\n" +
                ".show-menu{\n" +
                "    bottom: 0;\n" +
                "}\n" +
                "\n" +
                "/* Active link */\n" +
                ".active-link{\n" +
                "    color: var(--text-color);\n" +
                "}\n" +
                "\n" +
                "/* Change background header */\n" +
                ".scroll-header{\n" +
                "    box-shadow: 0 -1px 4px rgba(0, 0, 0, .15);\n" +
                "}\n" +
                "\n" +
                "/*==================== HOME ====================*/\n" +
                ".home__title{\n" +
                "    font-size: var(--big-font-size);\n" +
                "    text-align: center;\n" +
                "    padding-top: 1rem;\n" +
                "}\n" +
                "\n" +
                "/*==================== Report ====================*/\n" +
                ".report__container{\n" +
                "    row-gap: 0;\n" +
                "}\n" +
                "\n" +
                ".report__header{\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    margin-bottom: var(--mb-2-5);\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                "\n" +
                ".report__icon,\n" +
                ".report__arrow{\n" +
                "    font-size: 2rem;\n" +
                "    color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                ".report__icon{\n" +
                "    margin-right: var(--mb-0-75);\n" +
                "}\n" +
                "\n" +
                ".report__title{\n" +
                "    font-size: var(--h3-font-size);\n" +
                "}\n" +
                "\n" +
                ".report__subtitle{\n" +
                "    font-size: var(--small-font-size);\n" +
                "    color: var(--text-color-light);\n" +
                "}\n" +
                "\n" +
                ".report__arrow{\n" +
                "    margin-left: auto;\n" +
                "    transition: .4s;\n" +
                "}\n" +
                "\n" +
                ".report__list{\n" +
                "    row-gap: 1.5rem;\n" +
                "    padding-left: 2.7rem;\n" +
                "}\n" +
                "\n" +
                ".report__titles{\n" +
                "    display: flex;\n" +
                "    justify-content: space-between;\n" +
                "    margin-bottom: var(--mb-0-5);\n" +
                "}\n" +
                "\n" +
                ".report__name{\n" +
                "    font-size: var(--normal-font-size);\n" +
                "    font-weight: var(--font-medium);\n" +
                "}\n" +
                "\n" +
                ".report__bar,\n" +
                ".report__percentage{\n" +
                "    height: 5px;\n" +
                "    border-radius: .25rem;\n" +
                "}\n" +
                "\n" +
                ".report__bar{\n" +
                "    background-color: var(--first-color-lighter);\n" +
                "}\n" +
                "\n" +
                ".report__percentage{\n" +
                "    display: block;\n" +
                "    background-color: var(--first-color);\n" +
                "}\n" +
                "\n" +
                ".report__line{\n" +
                "    width: 100%;\n" +
                "}\n" +
                "/*==================== FOOTER ====================*/\n" +
                ".footer{\n" +
                "    padding-top: 2rem;\n" +
                "}\n" +
                "\n" +
                ".footer__container{\n" +
                "    row-gap: 3.5rem;\n" +
                "}\n" +
                "\n" +
                ".footer__link:hover{\n" +
                "    color: var(--first-color-lighter);\n" +
                "}\n" +
                "\n" +
                ".footer__copy{\n" +
                "    font-size: var(--small-font-size);\n" +
                "    text-align: center;\n" +
                "    color: var(--text-color-light);\n" +
                "    margin-top: var(--mb-3);\n" +
                "}\n" +
                ".footer__link{\n" +
                "    color: #FFF;\n" +
                "}\n" +
                "/*========== SCROLL UP ==========*/\n" +
                ".scrollup{\n" +
                "    position: fixed;\n" +
                "    right: 1rem;\n" +
                "    bottom: -20%;\n" +
                "    background-color: var(--first-color);\n" +
                "    opacity: .8;\n" +
                "    padding: 0 .3rem;\n" +
                "    border-radius: .4rem;\n" +
                "    z-index: var(--z-tooltip);\n" +
                "    transition: .4s;\n" +
                "}\n" +
                "\n" +
                ".scrollup:hover{\n" +
                "    background-color: var(--first-color-alt);\n" +
                "}\n" +
                "\n" +
                ".scrollup__icon{\n" +
                "    font-size: 1.5rem;\n" +
                "    color: #FFF;\n" +
                "}\n" +
                "\n" +
                "/* Show scroll */\n" +
                ".show-scroll{\n" +
                "    bottom: 5rem;\n" +
                "}\n" +
                "\n" +
                "/*========== SCROLL BAR ==========*/\n" +
                "\n" +
                "\n" +
                "/*==================== MEDIA QUERIES ====================*/\n" +
                "/* For small devices */\n" +
                "@media screen and (max-width:350px){\n" +
                "    .container{\n" +
                "        margin-left: var(--mb-1);\n" +
                "        margin-right: var(--mb-1);\n" +
                "    }\n" +
                "\n" +
                "    .nav__menu{\n" +
                "        padding: 2rem .25rem 4rem;\n" +
                "    }\n" +
                "    .nav__list{\n" +
                "        column-gap: 0;\n" +
                "    }\n" +
                "\n" +
                "    .home__content{\n" +
                "        grid-template-columns: .25fr 3fr;\n" +
                "    }\n" +
                "    .home__blob{\n" +
                "        width: 180px;\n" +
                "    }\n" +
                "\n" +
                "    .report__title{\n" +
                "        font-size: var(--normal-font-size);\n" +
                "    }\n" +
                "    \n" +
                "}\n" +
                "\n" +
                "/* For medium devices */\n" +
                "@media screen and (min-width: 568px){\n" +
                "    .home__content{\n" +
                "        grid-template-columns: max-content 1fr 1fr;\n" +
                "    } \n" +
                "}\n" +
                "\n" +
                "@media screen and (min-width: 768px){\n" +
                "    .container{\n" +
                "        margin-left: auto;\n" +
                "        margin-right: auto;\n" +
                "    }\n" +
                "\n" +
                "    body{\n" +
                "        margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    .section{\n" +
                "        padding: 6rem 0 2rem;\n" +
                "    }\n" +
                "    .section__subtitle{\n" +
                "        margin-bottom: 4rem;\n" +
                "    }\n" +
                "    .header{\n" +
                "        top: 0;\n" +
                "        bottom: initial;\n" +
                "    }\n" +
                "\n" +
                "    .header,\n" +
                "    .main,\n" +
                "    .footer__container{\n" +
                "        padding: 0 1rem;\n" +
                "    }\n" +
                "\n" +
                "    .nav{\n" +
                "        height: calc(var(--header-height) + 1.5rem);\n" +
                "        column-gap: 1rem;\n" +
                "    }\n" +
                "    .nav__icon,\n" +
                "    .nav__close,\n" +
                "    .nav__toggle{\n" +
                "        display: none;\n" +
                "    }\n" +
                "\n" +
                "    .nav__list{\n" +
                "        display: flex;\n" +
                "        column-gap: 2rem;\n" +
                "    }\n" +
                "    .nav__menu{\n" +
                "        margin-left: auto;\n" +
                "    }\n" +
                "\n" +
                "    .change-theme{\n" +
                "        margin: 0;\n" +
                "    }\n" +
                "\n" +
                "    .home__content{\n" +
                "        padding-top: 5.5rem;\n" +
                "        column-gap: 2rem;\n" +
                "    }\n" +
                "    .report__container{\n" +
                "        margin-left: 1rem;\n" +
                "        margin-right: 2rem;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "/* For large devices */\n" +
                "@media screen and (min-width: 1024px){\n" +
                "    .header,\n" +
                "    .main,\n" +
                "    .footer__container{\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    .home__social{\n" +
                "        transform: translateX(-6rem)\n" +
                "    }\n" +
                "\n" +
                "    .report__container{\n" +
                "        margin-left: 5rem;\n" +
                "        margin-right: 5rem;\n" +
                "    }\n" +
                "\n" +
                "    .contact__form{\n" +
                "        width: 460px;\n" +
                "    }\n" +
                "\n" +
                "    .contact__inputs{\n" +
                "        grid-template-columns: repeat(2, 1fr);\n" +
                "    }\n" +
                "}"+
                "        </style>"+
                "        \n" +
                "        <title>Relatório</title>\n" +
                "    </head>";

    }

    @Override
    public void body() throws Exception {
        content += "<body>\n" +
                "        <!--==================== HEADER ====================-->\n" +
                "        <header class=\"header\" id=\"header\">\n" +
                "            <h1 class=\"home__title\">Detalhes de Logins</h1>\n" +
                "        </header>\n" +
                "\n" +
                "        <!--==================== MAIN ====================-->\n" +
                "        <main class=\"main\">\n" +
                "            <section class=\"report section\" id=\"report\">\n" +
                "                <div class=\"report__container\">\n" +
                "                    <div>\n" +
                "                        <!--==================== report 1====================-->\n" +
                "                        <div class=\"report__content report__open\">\n" +
                "                            <div class=\"report__list grid\">";

        ArrayList<User> users = getUsers();

        for(User u: users){
            content +=
                    "<div class=\"report__data\">\n" +
                            "                                    <div class=\"report__titles\">\n" +
                            "                                        <h3 class=\"report__name\">"+u.getName()+"</h3>\n" +
                            "                                        <span class=\"report__number\">"+u.getAmountAccess()+"</span>\n" +
                            "                                    </div>\n" +
                            "                                    <div class=\"report__bar\">\n" +
                            "                                        <span class=\"report__percentage report__line\"></span>\n" +
                            "                                    </div>\n" +
                            "                                </div>";
        }

                content +=
                " </div>\n" +
                        "                        </div>\n" +
                        "            </section>\n" +
                        "        </main>                \n" +
                        "        <!--==================== FOOTER ====================-->\n" +
                        "        <footer class=\"footer\">\n" +
                        "                <div class=\"footer__container container grid\">\n" +
                        "                    <p class=\"footer__copy\">&#169; Verbum APP. All right reserved</p>\n" +
                        "                </div>\n" +
                        "        </footer>\n" +
                        "        \n" +
                        "        <!--==================== SCROLL TOP ====================-->\n" +
                        "        <a href=\"#\" class=\"scrollup\" id=\"scroll-up\">\n" +
                        "            <i class=\"uil uil-arrow-up scrollup__icon\"></i>\n" +
                        "        </a>\n" +
                        "\n" +
                        "        <!--==================== SWIPER JS ====================-->\n" +
                        "        <script src=\"\"></script>\n" +
                        "\n" +
                        "        <!--==================== MAIN JS ====================-->\n" +
                        "        <script src=\"assets/js/main.js\"></script>\n" +
                        "    </body>\n" +
                        "</html>";

    }

    public ArrayList<User> getUsers(){
        UserPersistence userPersistence = new UserPersistence();
        return userPersistence.load(context);
    }


}
