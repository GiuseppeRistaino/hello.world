package com.dd.vrexas.ddmanuale.DbHelper;

/**
 * Created by Vrexas on 07/02/2016.
 */
public class DBManagerD_D {

    public static final String DB_NAME = "Dungeons&Dragons";

    public static final String[] COLUMNS_ARMA = new String[] {"Nome","Tipo","Costo","Danni_piccola",
            "Danni_media","Critico","Gittata","Peso"};
    public static final String TABLE_NAME_ARMI = "Arma";

    public static final String[] COLUMNS_MOSTRO = new String[] { "_Nome", "Tipo", "Taglia", "Vita",
            "Iniziativa", "Velocità", "CA", "Attacco_base", "Lotta", "Attacco", "Attacco_completo",
            "Spazio", "Portata", "Attacco_speciale", "Qualità_speciale", "Tiri_salvezza", "Forza",
            "Destrezza", "Costituzione", "Intelligenza", "Saggezza", "Carisma", "Abilità",
            "Talento", "Organizzazione", "Grado_di_sfida", "Tesoro", "Allineamento",
            "Modificatore_di_livello", "Descrizione", "Combattimento"};
    public static final String TABLE_NAME_MOSTRI = "Mostro";

    public static final String[] COLUMNS_ABILITY = new String[] {
            "Nome",
            "Descrizione",
            "Prova",
            "Azione",
            "Ritentare",
            "Speciale",
            "Sinergia",
            "Restrizioni",
            "Senza_addestramento"};
    public static final String TABLE_NAME_ABILITY = "Ability";

    public static final String[] COLUMNS_ESEMPIO = new String[] {"Nome","Prova"};
    public static final String TABLE_NAME_ESEMPIO = "Esempio";

}
