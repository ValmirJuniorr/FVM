package br.com.fvm.model;

/**
 * Created by Valmir on 25/05/2016.
 */
public class Constants {
    public static final String DATA_BASE_FVM="FVM";
    public static final int VERSION_DATA_BASE_FVM=1;

    /* define of the name's tables */

    //Constants para a table user
    public static final String NAME_TABLE_USER="users";
    public static final String COLLUMN_ID_USER="id_user";
    public static final String COLLUMN_NAME_USER ="name";
    public static final String COLLUMN_EMAIL_USER ="email";
    public static final String COLLUMN_LOGIN_USER ="login";
    public static final String COLLUMN_PASSWORD_USER ="password";

    //Constants para a table product
    public static final String NAME_TABLE_PRODUCT="products";
    public static final String COLLUMN_ID_PRODUCT="id_product";
    public static final String COLLUMN_NAME_PRODUCT ="name";
    public static final String COLLUMN_DESCRIPTION_PRODUCT ="description";
    public static final String COLLUMN_PRICE_PRODUCT ="price";

    public static final String NAME_TABLE_ITEM="items";
    public static final String COLLUMN_ID_ITEM="id_item";
    public static final String COLLUMN_NAME_ITEM ="name";
    public static final String COLLUMN_DESCRIPTION_ITEM ="description";
    public static final String COLLUMN_NAME_PRICE_ITEM ="price";

    public static final String NAME_TABLE_ORDER="orders";
    public static final String COLLUMN_ID_ORDER="id_order";
    public static final String COLLUMN_DATE_OPEN_ORDER="orders";
    public static final String COLLUMN_DATE_REALIZED_ORDER ="orders";
    public static final String COLLUMN_DATE_IN_ATTENDANCE_ORDER="orders";
    public static final String COLLUMN_DATE_DELIVERED_ORDER="orders";
    public static final String COLLUMN_DATE_EMPLOYEE_ORDER="orders";



    public static final String NAME_TABLE_ITEM_PRODUCT="items_products";


    public static final String NAME_TABLE_ITEM_PRODUCT_ADDITIONAL="items_products_additional";
    public static final String NAME_TABLE_PRODUCT_ORDER="products_orders";



}
