package net.virtela.vendor.api.report.util;

public class Constants {
	
	//LOGIN
	public static final String LOGIN_NCOP = "NCOP";
	public static final String LOGIN_PSP = "SALES-PORTAL";

	// STATUS LOG TYPE
	public static final Long PROJECT_STATUS_LOG_TYPE_ID = 1l;
	public static final Long ITEM_STATUS_LOG_TYPE_ID = 2l;

	// PSP
	public static final String DATE_FORMAT_PSP = "dd-MMM-yyyy";
	public static final String DATE_FORMAT_SALES = "MM/dd/yyyy";
	
	//Properties
	public static final long MULTI_HOP_OFFNET_PROPERTY_ID = 1005;
	public static final long MULTI_HOP_ONNET_MASTER_PROPERTY_ID = 1006;
	public static final long REWORK_FLAG_PROPERTY_ID = 1007;
	public static final long SECONDARY_CONTACT_PROPERTY_ID = 1008;
	public static final long NON_BH_PROPERTY_ID = 1009;
	public static final long CARRIERS_TO_AVOID_PROPERTY_ID = 1010;
	public static final long CE_PREMIUM_PROPERTY_ID = 1011;
	public static final long DUE_DATE_CONFIRMATION_PROPERTY_ID = 1012;
	public static final long AM_EST_DATE_FLAG_PROPERTY_ID = 1013;
	
	public static final String NULL_STRING = "null";
	
	public static final int WIC_CARD_LIMIT = 12; 
	
	// DOCUMENT TYPE
	public static final Long DOCUMENT_TYPE_ID_CIF = 3l;
	public static final Long DOCUMENT_TYPE_ID_SCR = 4l;
	public static final Long DOCUMENT_TYPE_ID_ORDER_FORMS = 9l;
	public static final Long DOCUMENT_TYPE_ID_DIAGRAMS = 17l;

	// FILE NAME FORMAT MAPPING KEY

	public static final String NAME_FORMAT_KEY_ACG = "<ACG>";
	public static final String NAME_FORMAT_KEY_QUOTE_ID = "<QUOTE_ID>";
	public static final String NAME_FORMAT_KEY_NTT_ORDER_ID = "<NTT_ORDER_ID>";
	public static final String CIF_FILE_NAME_FORMAT = "CIF_<NTT_ORDER_ID>_<ACG>_<QUOTE_ID>";
	public static final String CIF_DISCO_FILE_NAME_FORMAT = "CIFDisconnect_<NTT_ORDER_ID>";
	public static final Long PROPERTY_ID_SEQUENCED = 1003l;
	// STATE
	public static final String STATE_INTL = "INT'L";
	
    /** Estimated Date **/
    public static final String AM_DELAY_ITEM_ID = "itemId";
    public static final String AM_DELAY_NOTE_KEY = "delayNote";
    
    public static final String NON_BH_AL = "AL";
    public static final String NON_BH_AL_CPE = "AL & CPE";
    
	// ApplicationIds
	public static final Long APP_ID_PSP = 23l;
	public static final Long APP_ID_NCOP = 24l;
	public static final Long APP_ID_CIF = 27l;
	public static final Long APP_ID_SALES_WS = 29l;

	// PSP Affiliate ID
	public static final Long AFFILIATE_ID_NTT_COM = 167l;
	public static final Long AFFILIATE_ID_NTT_EUROPE = 165l;
	public static final Long AFFILIATE_ID_NTT_SINGAPORE = 161l;
	public static final Long AFFILIATE_ID_NTT_AMERICA = 174l;
	
	public static final Long AFFILIATE_ID_NTT_COM_ASIA = 173l;
	public static final Long AFFILIATE_ID_NTT_ICT = 164l;
	public static final Long AFFILIATE_ID_NTT_COM_INDONESIA = 170l;
	public static final Long AFFILIATE_ID_NTT_TAIWAN = 160l;
	public static final Long AFFILIATE_ID_PLDT = 308l;
	public static final Long AFFILIATE_ID_NTT_MSC = 162l;
	public static final Long AFFILIATE_ID_NTT_KOREA = 166l;
	public static final Long AFFILIATE_ID_NTT_COM_VIETNAM = 168l;
	public static final Long AFFILIATE_ID_NTT_COM_THAI = 169l;
	public static final Long AFFILIATE_ID_NTT_COM_CHINA = 172l;
	public static final Long AFFILIATE_ID_NTT_BRAZIL = 171l;
	
	//Virtela Partner IDs
	public static final Long AFFILIATE_ID_HITACHI = 361l;
	public static final Long AFFILIATE_ID_AIRCEL = 181l;
	public static final Long AFFILIATE_ID_FUJITSU = 224l;
	public static final Long AFFILIATE_ID_IBM = 236l;
	public static final Long AFFILIATE_ID_KDDI = 255l;
	public static final Long AFFILIATE_ID_MACQUARIE = 262l;
	public static final Long AFFILIATE_ID_VIRTELA = 354l;

	// PSP Permission
//	public static final Long PSP_PERMISSION_ID_VIEW_ALL_PROJECTS = 15l;
	public static final Long PSP_PERMISSION_ID_VIEW_ALL_NTT_PROJECTS = 48l;
	public static final Long PSP_PERMISSION_ID_VIEW_ALL_VIRTELA_PROJECTS = 49l;
	public static final Long PSP_PERMISSION_ID_AFFILIATE_SALES_COMM = 20l;
	public static final Long PSP_PERMISSION_ID_SALES_PRICING_AFFILIATE_COM = 21l;
	public static final Long PSP_PERMISSION_ID_VIEW_QUOTE_INFO = 44l;

	// PSP Permission
	public static final Long CIF_PERMISSION_ID_VIEW_ALL_PROJECTS = 23l;

	public static final String EMPTY = "(Empty)";
	public static final String EMPTY_STRING = "";
	public static final String SALES_WS = "Sales WebService";
	public static final int DB_MAX_IN_CLAUSE_COUNT = 999;

	// HEADER
	public static final String HEADER_SECURITY_TOKEN = "Security-Token";
	public static final String HEADER_APPLICATION_ID = "Application-Id";

	// Cache
	public static final int CACHE_EXPIRY_24HR = 24;
	public static final int CACHE_EXPIRY_12HR = 12;

	public static final long LEAD_TIME_SIX_WEEKS = 6;

	public static final String SUFFIX_VERSION = "VER";

	//
	public static final String COLON = ":";
	public static final String SEMI_COLON = ";";
	public static final String SPACE = " ";
	public static final String COMMA = ",";
	public static final String UNDERSCORE = "_";
	public static final String HASH = "#";
	public static final String DASH = "-";
	public static final String QUESTION_MARK = "?";
	public static final String VERSION_SUFFIX = "ver";
	public static final String JSON = "json";
	public static final String SLASH = "/";
	public static final String BACK_SLASH = "\\";
	public static final String DOT = ".";
	public static final String DASH_SPACE = " - ";
	public static final String DOLLAR = "$";
	public static final String EMAIL_SEPARATOR = ", ";
	public static final String SPECIAL_SEPARATOR = "<@>";
	public static final String ASTERISK = "*";
	public static final String PIPE = "|";
	public static final String DOUBLE_QUOTE = "\"";
	public static final String LESS_THAN = "<";
	public static final String GREATHER_THAN = "<";
	public static final String STATUS_INFO_SEPERATOR = " - ";
	public static final String EQUAL = "=";

	public static final String ZERO = "0";

	public static final String FILE_TYPE_ZIP = "zip";
	
	public static final String MEGABYTE_SUFFIX = "M";
	public static final String GIGABYTE_SUFFIX = "G";
	public static final String NA = "N/A";

	// HTML
	public static final String HTML_NEW_LINE = "<BR/>";

	// Pain Test
	public static final String PLAIN_TEXT_NEW_LINE = "\n";

	// Boolean Flag
	public static final String BOOLEAN_STR_TRUE = "T";
	public static final String BOOLEAN_STR_FALSE = "F";
	public static final String BOOLEAN_STR_ACTIVE = "1";
	public static final String BOOLEAN_STR_IN_ACTIVE = "0";
	public static final String BOOLEAN_STR_YES = "Y";
	public static final String BOOLEAN_YES = "YES";
	public static final String BOOLEAN_FLASE = "False";
	public static final String FOR_CONFIRMATION_STR_FLAG = "C";
	public static final String BOOLEAN_TRUE = "True";


	public static final String STR_YES = "Yes";
	public static final String STR_NO = "No";
	public static final String STR_OK = "OK";

	public static final int BOOLEAN_INT_TRUE = 1;
	public static final int BOOLEAN_INT_FALSE = 0;
	public static final int INT_TWO = 2;
	public static final int INT_THREE = 3;

	// Hardware Provided Values
    public static final int HW_PROVIDER_VIRTELA_ID = 1;
    public static final int HW_PROVIDER_CUSTOMER_ID = 2;
    public static final int HW_PROVIDER_EXISTING_ID = 3;
    public static final int HW_PROVIDER_SAME_AS_ABOVE_ID = 4;
    public static final int HW_PROVIDER_SAME_AS_BELOW_ID = 5;
    public static final int HW_PROVIDER_NTT_COM_ID = 6;
    public static final int HW_PROVIDER_CARRIER_ID = 7;
    public static final int HW_PROVIDER_COM_CHINA_ID = 8;
    
    public static final String HW_PROVIDER_VIRTELA = "Virtela";
    public static final String HW_PROVIDER_CUSTOMER = "Customer";
    public static final String HW_PROVIDER_EXISTING = "Existing";
    public static final String HW_PROVIDER_SAME_AS_ABOVE = "Same As Above";
    public static final String HW_PROVIDER_SAME_AS_BELOW = "Same As Below";
    public static final String HW_PROVIDER_NTT = "NTT";
    public static final String HW_PROVIDER_NTT_COM = "NTT Com";
    public static final String HW_PROVIDER_CARRIER = "Carrier";
    public static final String HW_PROVIDER_COM_CHINA = "Com China";

	public static final String MULTI_CAST_GSR = "Yes (GSR)";
	public static final String MULTI_CAST_JUNIPER = "Yes (Juniper)";	
	public static final Long JUMBO_FRAME_1900 = 1900L;

	// URL Injection
	public static final String URL_PARAM_INDICATION = "?";

	public static final String URL_PARAM_SEPARATOR = ";";
	
	//MAP Keys
	public static final String STD_DUE_DATE_KEY = "STANDARD_DUE_DATE";
	public static final String EST_DUE_DATE_KEY = "ESTIMATED_DUE_DATE";
	
	// Virtela Products
	public static final String VIRTELA_MPLS = "Virtela MPLS";
	public static final String PRIVATE_VPN = "Private VPN";
	public static final String BROADBAND_VPN = "Broadband VPN";
	public static final String INTERNET_SERVICES = "Internet Services";
	public static final String VIRTELA_VPLS = "Virtela VPLS";

	// FILE
	public static final Integer MB_FILE_SIZE_LIMIT = 20;

	// EMAIL Constants

	public static final String MALING_LIST_CE_TEAM = "PCteam@lists.virtela.net";
	
    public static final String MALING_LIST_NTTA_TEAM = "SOCOMM@ntta.com";
	
	public static final String MALING_LIST_SSO_TEAM = "seamless-so-cs@ntt.com";
	
	public static final String MALING_LIST_NTTE_TEAM = "eSOC@ntt.eu";
	public static final String PARTNER_NTTA = "NTT America";
	public static final String PARTNER_NTTE = "NTT Europe";
	public static final String MAILING_LIST_NTT_PM = "nttrfq@virtela.net";

	public static final String MAILING_LIST_LOCAL_SERVER = "kmojica@virtela.net, rreyles@virtela.net";
	public static final String MAILING_LIST_TEST_SERVER = "kmojica@virtela.net, rreyles@virtela.net, cproost@virtela.net, psra@virtela.net, jplaton@virtela.net, amadrelejos@virtela.net, slokhande@virtela.net, masharma@virtela.net, vnadal@virtela.net, ssurendran@virtela.net";
	public static final String AVP_DEV_MAILING_LIST = "jyau@virtela.net"; 

	public static final String LOWEST_COST_MAPPING_ADMINS = "cproost@virtela.net, rreyles@virtela.net, psra@virtela.net";

	public static final String MAILING_LIST_CIF_RECIPIENT = "rreyles@virtela.net, jtransfiguracion@virtela.net, rhidalgo@virtela.net, surtripathi@virtela.net, bbrenner@virtela.net, pnair@virtela.net, sniwas@virtela.net,aduggal@virtela.net";
	public static final String PSP_DEV_MAILING_LIST = "rreyles@virtela.net, kmojica@virtela.net, rbaraquio@virtela.net, slokhande@virtela.net, ssurendran@virtela.net";
	public static final String CIF_DEV_MAILING_LIST = "sniwas@virtela.net, pshah@virtela.net, rreyles@virtela.net, jtransfiguracion@virtela.net, rhidalgo@virtela.net, surtripathi@virtela.net, bbrenner@virtela.net, pnair@virtela.net,aduggal@virtela.net";
	public static final String API_MCC_MAIL = "rhidalgo@virtela.net, ";
	
	public static final String EMAIL_KEY_ASSIGNED_PM = "[AssignedPM]";
	public static final String EMAIL_KEY_PSP_CONTACT = "[PSPContact]";
	public static final String EMAIL_KEY_REQUEST_DETAILS_TABLE = "[requestDetails]";
	public static final String EMAIL_KEY_CHANGE_REQUESTS_BODY = "[changeRequestTable]";
	public static final String EMAIL_KEY_PARTNER_NAME = "[partnerName]";
	public static final String EMAIL_KEY_CUSTOMER_NAME = "[customerName]";
	public static final String EMAIL_KEY_VIRTELA_PROJECT_ID = "[ProjectID]";
	public static final String EMAIL_KEY_CRM_ID = "[crmQuoteReferenceId]";
	public static final String EMAIL_KEY_DATE = "[Date]";
	public static final String EMAIL_KEY_LINE_ID = "[LineID]";
	public static final String EMAIL_KEY_SENDER_NAME = "[Username]";
	public static final String PROJECT_LINK_KEY = "[ProjectURL]";
	public static final String EMAIL_KEY_SALES_PROJECT_ID = "[SalesProjectId]";
	public static final String EMAIL_KEY_SALES_QUOTE_ID = "[SalesQuoteId]";
	public static final String EMAIL_KEY_NTT_ID = "[NTTId]";

	public static final String EMAIL_KEY_REQUEST_STATUS = "[ChangeRequestStatus]";
	public static final String EMAIL_KEY_REQUEST_FIELD_NAME = "[FieldName]";
	public static final String EMAIL_KEY_STATUS_CHANGE_ACTION = "[StatusChangeAction]";
	public static final String STATUS_CHANGE_ACTION = "CANCELLATION";

	public static final String EMAIL_TABLE_HEADER_ITEM_ID = "Line ID";
	public static final String EMAIL_TABLE_HEADER_PROJECT_ID = "Project ID";
	public static final String EMAIL_TABLE_HEADER_REQUESTED_BY = "Requested By";
	public static final String EMAIL_TABLE_HEADER_REQUESTED_DATE = "Requested Date";
	public static final String EMAIL_TABLE_HEADER_REGION = "Region";
	public static final String EMAIL_TABLE_HEADER_COUNTRY = "Country";
	public static final String EMAIL_TABLE_HEADER_ACCESS_TYPE = "Access Type";
	public static final String EMAIL_TABLE_HEADER_VIRTELA_PRODUCT = "Virtela Product";
	public static final String EMAIL_TABLE_HEADER_SPEED = "Speed";
	public static final String EMAIL_TABLE_HEADER_LOW_COST_MAPPING_IDS = "Lowest Cost Mapping IDs";

	public static final String EMAIL_TABLE_HEADER_FIELD_NAME = "Field";
	public static final String EMAIL_TABLE_HEADER_OLD_VALUE = "Old Value";
	public static final String EMAIL_TABLE_HEADER_NEW_VALUE = "New Value";
	public static final String EMAIL_TABLE_HEADER_STATUS = "Status";
	public static final String EMAIL_TABLE_ITEM_ID = "Item ID";
	public static final String EMAIL_TABLE_HEADER_VALUE = "Value";

	public static final String EMAIL_BODY_REQ_DETAILS_TABLE_START_TAG = "<table style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 13px; color: #333333; font-stretch: semi-condensed;border-collapse:collapse\">";
	public static final String EMAIL_BODY_REQ_DETAILS_TABLE_END_TAG = "</table>";
	public static final String EMAIL_BODY_CHANGE_REQUEST_TABLE_HTML_START = "<table style=\"font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 13px; color: #333333; font-stretch:semi-condensed;border-collapse:collapse\"><tbody>";
	public static final String EMAIL_BODY_CHANGE_REQUEST_TABLE_HTML_END = "</tr></tbody></table>";
	public static final String EMAIL_BREAK_TAG = "<br>";

	public static final String LOWEST_COST_MAP_SUBJECT_MISSING_RULE = "Lowest Cost Conversion - Missing Rule";
	public static final String LOWEST_COST_MAP_SUBJECT_DUPLICATE_RULE = "Lowest Cost Conversion - Duplicate Rule";
	public static final String AUTOMATIC_EMAIL_NOTIFICATION = "This is an automated email.";

	// Source
	public static final String QUOTE_SOURCE_NDA_API = "NDA API";
	public static final String QUOTE_SOURCE_COST_TABLE = "Cost Table";
	public static final String QUOTE_SOURCE_COMPLETEL_API = "Completel API";
	public static final String QUOTE_SOURCE_TELE2_API = "Tele2 API";
	public static final String QUOTE_SOURCE_VIRTUAL_ONE_API = "VirtualOne API";
	public static final String QUOTE_SOURCE_COLT_API = "Colt API";
	public static final String QUOTE_SOURCE_TALK_TALK_API = "Talk Talk API";
	public static final String QUOTE_SOURCE_HISTORICAL_EXACT = "[HEM]";
	public static final String QUOTE_SOURCE_HISTORICAL = "[HM]";
	public static final String QUOTE_SOURCE_VENDOR_API = "Vendor API";
	public static final String QUOTE_SOURCE_HISTORY = "Historical";
	public static final String QUOTE_SOURCE_SFR = "SFR API";
	public static final String QUOTE_SOURCE_SSE = "SSE API";
	public static final String QUOTE_SOURCE_VERIZON = "Verizon API";
	public static final String QUOTE_SOURCE_SFR_INDIA = "SFR India API";
	public static final String QUOTE_SOURCE_COMCAST_API = "Comcast API";
	public static final String QUOTE_SOURCE_NEUTRONA_API = "Neutrona API";
	public static final String QUOTE_SOURCE_PROXIMUS_API = "Proximus API";
	public static final String QUOTE_SOURCE_CHARTER_API = "Charter API";

	public static final String QB_TYPE_QUOTE = "Quote";

	public static final String VENDOR_NAME_COLT = "Colt Telecom";

	// SPEED
	public static final long SPEED_1_M = 1_000;
	public static final long SPEED_10_M = 10_000;
	public static final long SPEED_20_M = 20_000;
	public static final long SPEED_100_M = 100_000;
	public static final long SPEED_300_M = 300_000;
	public static final long SPEED_1_G = 1_000_000;

	// Access Type
	public static final String ACCESS_TYPE_ETHERNET = "Ethernet";
	public static final String ACCESS_TYPE_1XDS1 = "1xDS1";
	public static final String ACCESS_TYPE_2XDS1 = "2xDS1";
	public static final String ACCESS_TYPE_3XDS1 = "3xDS1";
	public static final String ACCESS_TYPE_4XDS1 = "4xDS1";
	public static final String ACCESS_TYPE_5XDS1 = "5xDS1";
	public static final String ACCESS_TYPE_6XDS1 = "6xDS1";
	public static final String ACCESS_TYPE_7XDS1 = "7xDS1";
	public static final String ACCESS_TYPE_DS3 = "DS3";
	public static final String ACCESS_TYPE_1XDS3 = "1xDS3";
	public static final String ACCESS_TYPE_2XDS3 = "2xDS3";
	public static final String ACCESS_TYPE_OC3 = "OC3";
	public static final String ACCESS_TYPE_GIGE = "Gig-E";
	public static final String ACCESS_TYPE_OC12 = "OC12";
	public static final String ACCESS_TYPE_CPA = "CPA";
	public static final String ACCESS_TYPE_CPIA = "CPIA";
	public static final String ACCESS_TYPE_10GIG = "10-gig";
	public static final Object ACCESS_TYPE_LOWEST_COST = "Lowest Cost";
	public static final Object ACCESS_TYPE_INTERNET_LOWEST_COST = "Internet Srvcs - Dedicated Access";
	public static final String ACCESS_TYPE_3G = "3G";

	// Product Option
	public static final Long PRODUCT_OPTION_ID_CIA_3GB = 16l;
	public static final Long PRODUCT_OPTION_ID_CIA_5GB = 17l;
	public static final Long PRODUCT_OPTION_ID_CIA_7GB = 18l;
	public static final Long PRODUCT_OPTION_ID_CIA_UNLIMITED = 19l;

	public static final String[] NDA_ACCESS_TYPES = { "1xDS3", "2xDS3", "8xDS1", "7xDS1", "6xDS1", "5xDS1", "4xDS1", "3xDS1", "2xDS1", "1xDS1", "DS3", "7xDS1 DIA", "6xDS1 DIA", "5xDS1 DIA", "4xDS1 DIA", "3xDS1 DIA", "2xDS1 DIA",
			"1xDS1 DIA", "OC3", "Ethernet", "Ethernet BB", "BB Ethernet", "Ethernet DIA", "EoDS1", "EoDS3", "EoOC3", "Fast-E", "FastEthernet", "GigE", "GigEthernet", "BB T1", "Gig-E" };

	// Virtela Product
	public static final String VIRTELA_PRODUCT_PRIVATE_VPN = "Private VPN";
	public static final String VIRTELA_PRODUCT_INTERNET_SERVICES = "Internet Services";
	public static final String VIRTELA_PRODUCT_VIRTELA_MPLS = "Virtela MPLS";
	public static final String VIRTELA_PRODUCT_VIRTELA_VPLS = "Virtela VPLS";
	public static final String VIRTELA_PRODUCT_BROADBAND_VPN = "Broadband VPN";
	public static final String VIRTELA_PRODUCT_CLOUD_BASED_DMVPN_PRIVATE_VPN = "Cloud based DMVPN - Private VPN";
	public static final String VIRTELA_PRODUCT_CLOUD_BASED_DMVPN_BROADBAND_VPN = "Cloud based DMVPN - Broadband VPN";
	public static final String VIRTELA_PRODUCT_CPE_BASED_DMVPN_PRIVATE_VPN = "CPE based DMVPN - Private VPN";
	public static final String VIRTELA_PRODUCT_CPE_BASED_DMVPN_BROADBAND_VPN = "CPE based DMVPN - Broadband VPN";

	public static final Long VIRTELA_PRODUCT_VPLS_ID = 74l;
	public static final Long VIRTELA_PRODUCT_MPLS_ID = 33l;
	public static final Long VIRTELA_PRODUCT_PRIVATE_VPN_ID = 34l;
	public static final Long VIRTELA_PRODUCT_BROADBAND_VPN_ID = 35l;
	public static final Long VIRTELA_PRODUCT_INTERNET_SERVICES_ID = 36l;
	public static final Long VIRTELA_PRODUCT_CPE_BASED_DMVPN_BROADBAND_VPN_ID = 75l;
	public static final Long VIRTELA_PRODUCT_CLOUD_BASED_DMVPN_BROADBAND_VPN_ID = 76l;
	public static final Long VIRTELA_PRODUCT_CPE_BASED_DMVPN_PRIVATE_VPN_ID = 77l;
	public static final Long VIRTELA_PRODUCT_CLOUD_BASED_DMVPN_PRIVATE_VPN_ID = 78l;

	// Country Code
	public static final String COUNTRY_CODE_FRANCE = "FR";
	public static final String COUNTRY_CODE_CANADA = "CA";
	public static final String COUNTRY_CODE_USA = "US";
	public static final String NETHERLANDS_COUNTRY_CODE = "NL";

	public static final String UNITED_KINGDOM_COUNTRY_CODE = "GB";
	public static final String AUSTRIA_COUNTRY_CODE = "AT";
	public static final String BELGIUM_COUNTRY_CODE = "BE";
	public static final String CZECH_REPUBLIC_COUNTRY_CODE = "CZ";
	public static final String DENMARK_COUNTRY_CODE = "DK";
	public static final String FINLAND_COUNTRY_CODE = "FI";
	public static final String GERMANY_COUNTRY_CODE = "DE";
	public static final String HUNGARY_COUNTRY_CODE = "HU";
	public static final String IRELAND_COUNTRY_CODE = "IE";
	public static final String ITALY_COUNTRY_CODE = "IT";
	public static final String LUXEMBOURG_COUNTRY_CODE = "LU";
	public static final String NORWAY_COUNTRY_CODE = "NO";
	public static final String POLAND_COUNTRY_CODE = "PL";
	public static final String PORTUGAL_COUNTRY_CODE = "PT";
	public static final String ROMANIA_COUNTRY_CODE = "RO";
	public static final String SLOVAKIA_COUNTRY_CODE = "SK";
	public static final String SPAIN_COUNTRY_CODE = "ES";
	public static final String SWEDEN_COUNTRY_CODE = "SE";
	public static final String SWITZERLAND_COUNTRY_CODE = "CH";

	// Country Names
	public static final String COUNTRY_NETHERLANDS = "Netherlands";
	public static final String COUNTRY_USA = "USA";
	public static final String COUNTRY_CANADA = "Canada";
	public static final String COUNTRY_UNITED_STATES = "United States";

	// Default LCC
	public static final String DEFAULT_LCC_TELE2 = "VNLAMS1";
	public static final String DEFAULT_LCC_COMPLETEL = "VFRPAR1";
	public static final String DEFAULT_LCC_VIRTUAL_ONE = "VGBLON3";
	public static final String DEFAULT_LCC_TALKTALK = "VGBLON3";

	// PMX ID
	public static final String COMPLETEL_PMX_ID = "XID00003118";
	public static final String TELE2_PMX_ID = "XID00003873";
	public static final String VIRTUAL_ONE_PMX_ID = "XID00004032";
	public static final String COLT_PMX_ID = "XID00003109";

	// PRVIDER
	public static final String VIRTUAL_ONE = "Virtual One";

	// CURRENCY
	public static final String CURRENCY_EURO = "EUR";
	public static final String CURRENCY_USD = "USD";
	public static final String CURRENCY_SWEDISH_KRONA = "SEK";
	public static final String CURRENCY_SWISS_FRANC = "CHF";
	public static final String CURRENCY_DANISH_KRONE = "DKK";
	public static final String CURRENCY_NDA_CANADA = "Canadian Dollar";
	public static final String CURRENCY_CANADA_CODE = "CAD";
	public static final String CURRENCY_GBP = "GBP";
	public static final String CURRENCY_THB = "THB";

	// TERMS
	public static final String TERM_TWELVE_MONTHS = "12";
	public static final String TERM_SIXTY_MONTHS = "60";
	public static final String TERM_FOURTHY_EIGHT_MONTHS = "48";
	public static final String TERM_THIRTY_SIX_MONTHS = "36";
	public static final String TERM_TWENTY_FOUR_MONTHS = "24";
	// public static final String TERM_TWELVE_MONTHS = "12";
	public static final String TERM_MONTH_TO_MONTH = "MTM";
	public static final String MONTHS = "Months";

	// Special Requests Lov
	public static final String LOV_VALUE_MULTICAST_JUNIPER = "Yes (Juniper)";
	public static final String LOV_VALUE_MULTICAST_GSR = "Yes (GSR)";
	public static final String LOV_VALUE_QOS_TYPE_4_CLASS_WITH_VOICE = "4 Class with Voice";
	public static final String LOV_VALUE_QOS_TYPE_4_CLASS_WITHOUT_VOICE = "4 Class without Voice";
	public static final String LOV_VALUE_QOS_TYPE_6_CLASS_WITH_VOICE = "6 Class with Voice";
	public static final String LOV_VALUE_QOS_TYPE_6_CLASS_WITHOUT_VOICE = "6 Class without Voice";

	// Pricing Portal
	public static final String SMALL_QUOTE_FORM = "Small Quote Form";
	public static final String INITIAL_SERVICE_TERM = "Initial Service Term: ";
	public static final String QUOTE_ID_TEXT = "Quote ID# ";
	public static final String QUOTE_DATE_TEXT = "Pricing herein is valid for up to 45 days from the following date: ";
	public static final String RFQ_TYPE_TEXT = "RFQ Type - ";
	public static final String ACG_TEXT = "ACG# ";
	public static final String CRM_QUOTE_ID_TEXT = "CRM Quote ID# ";
	public static final String PROJECT_ID_TEXT = "Project ID# ";
	public static final String QUOTE_TEXT = "Quote";

	// Hardware Provided
	public static final String HWP_YES = "Y";
	public static final String HWP_NO = "N";
	public static final String HWP_EXISTING = "E";
	public static final String HWP_SAME_AS_ABOVE = "S";
	public static final String HWP_SAME_AS_BELOW = "B";
	public static final String HWP_NTT = "P";
	public static final String HWP_VENDOR_LEASED = "V";

	// Quoted by
	public static final String QOUTED_BY_1 = "1";
	public static final String QOUTED_BY_2 = "2";
	public static final String QOUTED_BY_3 = "3";
	public static final String QOUTED_BY_VIRTELA = "Virtela";
	public static final String QOUTED_BY_NTT = "NTT";
	public static final String QOUTED_BY_FLOOR_PRICE = "Floor Price (Ratecard)";

	// RFQ Flag
	public static final String RFQ_FLAG_BOOLEAN_RFP = "P";
	public static final String RFQ_FLAG_RFQ = "RFQ";
	public static final String RFQ_FLAG_RFP = "RFP";
	public static final String RFQ_FLAG_NOT_RFQ = "Not RFQ or Not RFP";

	// Customer Type
	public static final String EXISTING_CUSTOMER = "Existing";
	public static final String NEW_CUSTOMER = "New";

	// PDF Small Quoteform
	// Price Table
	public static final String VIRTELA_HEADER = "Virtela";
	public static final String AMPERSAND = "&";
	public static final String ORDER_FORM_HEADER = "Order Form";
	public static final String LOCATION_HEADER = "Location";
	public static final String SERVICE_CATEGORIES_HEADER = "Service Categories";
	public static final String TYPE_HEADER = "Type";
	public static final String PORT_SPEED_HEADER = "Port Speed / Units";
	public static final String HARDWARE_HEADER = "Hardware";
	public static final String ACCESS_SPEED_HEADER = "Access Speed";
	public static final String VIRTELA_PROVIDED_ROUTER_HEADER = "Virtela Provided Router";
	public static final String MRC_HEADER = "MRC";
	public static final String NETWORK_CHARGE_HEADER = "Network Charge";
	public static final String NRC_HEADER = "NRC";
	public static final String ROUTER_CHARGE_HEADER = "Router Charge";
	public static final String NETWORK_INSTALL_HEADER = "Network Install including On-Site Install";
	public static final String MONTHLY_TOTAL_HEADER = "Monthly Total";
	public static final String ONE_TIME_TOTAL_HEADER = "One Time Total";
	public static final String TOTALS_FOOTER = "Totals";
	public static final float[] QUOTE_TITLE_WIDTHS = { 3, 5, 1 };
	public static final float[] PRICE_INFO_WIDTHS = { 4, 11, 10, 6, 4, 10, 4, 5, 0.1f, 5, 0.1f, 5, 5, 0.1f, 5, 5 };
	public static final float[] SIGNATURE_WIDTHS = { 0.55f, 5, 5 };
	public static final float[] CONTRACT_WIDTHS = { 0.55f, 10 };
	public static final float[] TERM_WIDTHS = { 0.55f, 6, 4 };
	public static final float[] LOCATION_INFO_WIDTHS = { 4, 5, 10, 10, 8, 8, 5, 5, 5, 4 };
	// Contract
	public static final String BY_TEXT = "By:                              ";
	public static final String SIGNATURE_TEXT = "(Authorized Signature)";
	public static final String PRINTED_NAME_TEXT = "(Typed or Printed Name)";
	public static final String DATE_TEXT = "(Date)";
	public static final String SPECIAL_TERM_TEXT = "Special Terms & Conditions";
	public static final String VALIDITY_TEXT = "This pricing is only valid for the sites and services listed above.";
	// Location Details
	public static final String LOC_DETAILS_HEADER = "Location Details";
	public static final String ID_HEADER = "ID";
	public static final String PHONE_NUMBER_HEADER = "Phone Number";
	public static final String PRI_ADDRESS_HEADER = "Primary Street Address";
	public static final String SEC_ADDRESS_HEADER = "Secondary Address";
	public static final String CITY_HEADER = "City";
	public static final String COUNTRY_HEADER = "Country";
	public static final String DIVERSITY_HEADER = "Diversity";
	public static final String WIC_HEADER = "WIC / License";
	public static final String CPE_HEADER = "Other CPEs";
	public static final String LINE_NUMBER_HEADER = "Line Number";

	// CIF SHEET
	public static final String CIF_SHEET_OVERVIEW = "Overview";
	public static final String CIF_SHEET_CONTACTINFO = "Contact Info";
	public static final String CIF_SHEET_SITEINFO = "Site Info";
	public static final String CIF_SHEET_VPNSERVICES = "VPN Services";
	public static final String CIF_SHEET_QOS = "QOS";
	public static final String CIF_SHEET_MACD = "MACD";
	public static final String CIF_SHEET_DISCO ="Disconnect";
	
	// CIF Email Message
	public static final String CIF_EMAIL_BODY_GREETING = "Dear <PMName>, <CEName>,";
	public static final String CIF_EMAIL_BODY = "There has been a new version of the CIF uploaded into the CIF portal by <LastUpdatedBy> at <Date>. Please refer the attachment in the portal and take the necessary action.";
	public static final String CIF_EMAIL_BODY_OTHERDOC = "There has been a new version of the <DocumentName> uploaded into the CIF portal under other documents by <LastUpdatedBy> at <Date>. Please refer the attachment in the portal and take the necessary action.";
	public static final String CIF_EMAIL_BODY_CLOSING = "Thanks & Regards," + HTML_NEW_LINE + "Virtela Powered by NTT";
	public static final String CIF_EMAIL_SUBJECT = "<FileName> : New CIF Uploaded";
	public static final String CIF_EMAIL_SUBJECT_OTHERDOC = "<ACG>_<QuoteID> <FileName> : New Document Uploaded";

	public static final String VHID_R = "R";
	public static final String VHID_VR = "VR";
	public static final String VHID_VH = "VH";
	
    public static final int AM_PROJECT_LEVEL_VIEW = 1;
    public static final int AM_ITEM_LEVEL_VIEW = 2;
    
    // Service Type
    public static final String SERVICE_TYPE_MPLS = "MPLS";
    
    public static final String NNI_LAYER_2 = "Layer 2";
    public static final String NNI_LAYER_3 = "Layer 3";
    public static final long DEFAULT_NON_LOWEST_COST_TAT = 5;
    
    //File Types
    public static final String FILE_TYPE_XLSX = "xlsx";
	public static final String FILE_TYPE_XLS = "xls";
	public static final String FILE_TYPE_XLSM = "xlsm";
	public static final String FILE_TYPE_PDF = "pdf";
	public static final String FILE_TYPE_CSV = "csv";
    
    //Data Status
    public static final String DATA_STATUS_MISSING_REQUIRED_FIELD = "Missing Required Field(s)";
    public static final String DATA_STATUS_DUPLICATE = "Duplicate";
    public static final String DATA_STATUS_INVALID = "Invalid";
    public static final String DATA_STATUS_UNSUPPORTED = "Unsupported";
    public static final String DATA_STATUS_ALLOWABLE_LENGTH_EXCEEDED ="Allowable Max Length/Value Exceeded";
    public static final String DATA_STATUS_INVALID_LAT_LON = "Invalid LAT/LON";
    public static final String DATA_STATUS_NO_ERROR = "No Error";
    
    //Thread count
    public static final int STANDARD_THREAD_COUNT = 20;
    public static final int MAX_THREAD_COUNT = 40;
    
    public static final String NOT_APPLICABLE = "N/A";
    public static final String MISSMATCH_RECORD = "Missmatch Record(s)";
    
	public static final String ATTRIBUTE_USER_ID = "User-Id";
	public static final String ATTRIBUTE_REQUEST_ID = "Request-Id";

	public static final String ENCODING_UTF8 = "UTF-8";
}
