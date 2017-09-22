package net.virtela.vendor.api.report.util;

public class AppMessage {
	
	/* ---------------------------- AUTHENTICATION MESSAGES ------------------------------------- */
	public static final String ERROR_UNAUTHORIZED_ACCESS = "Unauthorized Access";
	public static final String ERROR_AUTHENTICATION_FAILED = "Username and Password does not match";
	public static final String ERROR_NO_AUTHENTICATION = "Account is not yet login or Session expired";
	
	/* ---------------------------- GENERAL/DB MESSAGES ------------------------------------- */
	public static final String INFO_UPDATE_SUCCESS = "Record has been Updated";
	public static final String INFO_DELETE_SUCCESS = "Record has been Deleted";
	public static final String INFO_INSERT_SUCCESS = "Record has been Created";
	public static final String ERROR_UPDATE_FAILED = "Update Failed";
	public static final String ERROR_INSERT_FAILED = "Creation Failed";
	public static final String ERROR_DELETE_FAILED = "Failed to Delete Data";
	public static final String ERROR_ID_IS_EMPTY = "ID cannot be EMPTY";
	public static final String ERROR_DATA_NOT_FOUND = "Requested data does not exist";
	public static final String DUPLICATE_RECORD_FOUND = "Duplicate record found";
	public static final String ERROR_INVALID_PRIMARY_KEY = "Invalid Primary key has been supplied";
	public static final String ERROR_INVALID_PARAMETER = "Invalid paramater was supplied";
	public static final String ERROR_DELETE_INTEGRITY_CONSTRAINT = "Delete failed. There are existing reference/s to the record.";
	public static final String ERROR_READ_ONLY = "Record/Field is read-only";
	public static final String ERROR_MANDATORY = "Record/Field is mandatory";
	public static final String ERROR_AUTHORIZATION = "Account is not Authorized to access the service.";
	public static final String INFO_REQUEST_ACCEPTED = "Request Accepted!!";
	
	/* ---------------------------- SALES PROJECT RELATED ------------------------------------- */
	public static final String ERROR_SALES_PROJECT_DELETE_NOT_ALLOWED = "Sales Project is already launched and can no longer be deleted";
	public static final String ERROR_SALES_PROJECT_ID_IS_INVALID = "Sales Project Does Not Exist.";
	public static final String ERROR_CANCEL_PROJECT_IS_NOT_ALLOWED = "Sales Project status is beyond New, In-Progress, Re-Open or Virtela Reject and can no longer be Cancelled.";
	public static final String ERROR_CANCEL_PROJECT_HAS_NO_REASON = "A category is required to cancel the project";
	public static final String ERROR_PROJECT_LAUNCH_FAILED = "Unhandled Error occured. Project Launch Failed.";
	public static final String ERROR_ITEM_LAUNCH_REJECTED = "Project is already closed, System no longer allows new items to be added.";
	public static final String ERROR_CLOSE_PROJECT_IS_NOT_ALLOWED = "Project Cannot be Closed. Please make sure project's status is RFP Processed and all line items are Closed or Cancelled.";
	public static final String ERROR_REWOK_PROJECT_IS_NOT_ALLOWED = "Project Cannot be Reworked. Please make sure project's status is Closed, Virtela Reject or Cancelled.";
	public static final String ERROR_NO_REWORK_REASON = "Please provide a reason for Rework.";
	public static final String ERROR_OBJECT_CLONING_FAILED = "Error occured while cloning object. Please contact systems team.";
	public static final String ERROR_PROJECT_STATUS_INVALID_FOR_ITEM_REWORK = "Project must be reworked first before you can rework item individually.";
	public static final String ERROR_ITEM_STATUS_INVALID_FOR_REWORK = "Only Closed, Cancelled and Virtela Reject are allowed for rework.";
	public static final String ERROR_PROJECT_IS_ALREADY_LAUNCHED = "Project is already launched. Only projects in New and Rework status can be launched.";
	public static final String ERROR_PROJECT_HAS_NO_CHANGES = "There is no changes in the project.";
	public static final String ERROR_SALES_PROJECT_IN_PRICE_CHECK = "The Virtela pricing team is doing final price checks and you are no longer allowed to add or launch new line items as part of this project. Please either wait for this project completion or create a separate project to request price for new options/sites.";
	public static final String ERROR_SALES_DUE_DATE_ALREADY_PASSED = "SALES DUE DATE has passed. Please select another date.";
	public static final String ERROR_SALES_PROJECT_NOT_IN_PRICE_CHECK = "Project is not yet in pricing check";
	public static final String ERROR_NO_MERGEABLE_PROJECT_FOUND = "The Project is not suitable for merging. Or Project ID not found.";
	public static final String ERROR_SERVICE_TERM_NOT_EQUAL = "Service Terms are not the same.";
	public static final String ERROR_AFFILIATE_NOT_EQUAL = "Affiliates are not the same.";
	public static final String ERROR_RFQ_TYPE_NOT_EQUAL = "Cannot merge projects with different RFQ Types.";
	public static final String ERROR_CONFIRM_DUE_DATE = "Please confirm the Virtela Standard Due Date.";
	
	/* ---------------------------- SALES ITEM RELATED ------------------------------------- */
	public static final String ERROR_SALES_PROJECT_ITEM_DELETE_NOT_ALLOWED = "Sales Item is already launched and can no longer be deleted";
	public static final String ERROR_SALES_ITEM_MISSING_PROJECT_REFERENCE = "Sales Item has missing Sales Project reference.";
	public static final String ERROR_SALES_ITEM_STATUS_CANNOT_BE_LAUNCHED = "Sales Item status is beyond NEW or REWORK and can no longer be launched.";
	public static final String ERROR_SALES_ITEM_NOT_ADDRESS_VERIFIED_FOR_LAUNCH = "Sales Item cannot be launch. Address check is required to continue.";
	public static final String ERROR_ITEM_LAUNCH_FAILED = "Unhandled Error occured. Item Launch Failed.";
	public static final String ERROR_LAUNCH_EMPTY_ID_LIST = "Launch cannot proceed. Please send at least 1 sales item ID.";
	public static final String ERROR_SALES_ITEM_NOT_FOUND = "Sales Item Does Not Exist.";
	public static final String ERROR_NO_SALES_ITEMS_TO_UPLOAD = "Import cannot proceed. No valid line items are found. Please check your template or contact support.";
	public static final String ERROR_EXCEED_LIMIT_ID_LIST = "Item ID list has reached 1000 limit. Please reduce the number of item IDs.";
	public static final String ERROR_NOT_ALL_ITEMS_ARE_MERGED = "Not all items are merged with the project. Please check items.";
	public static final String ERROR_NO_ITEM_MERGED = "Not a single item is merged with the project. Please check items.";
	public static final String ERROR_CANCEL_ITEM_HAS_NO_REASON = "A category is required to cancel the item.";
	public static final String ERROR_INVALID_DIVERSITY_FORMAT = "Invalid diversity option format. Codes available are A, B and C only. (e.g. 2-A)";
	public static final String ERROR_EXCEEDED_WIC_CARD_LIMIT = "Exceeded allowed number of WIC Cards. (max of " + Constants.WIC_CARD_LIMIT + ")";
	public static final String ERROR_INVALID_WIC_CARD = "Invalid/Unregistered WIC card.";
	public static final String ERROR_ITEM_HAS_NO_CHANGES = "There is no changes in the item.";
	public static final String ERROR_NO_MATCHED_TAT = "No Matched Standard Due Date;";
	
	public static final String ERROR_INVALID_UNCLEAN_FLAG = "Invalid Unclean Flag - ";
	
	/* ---------------------------- ITEM/PROJECT IMPORT RELATED ------------------------------------- */
	public static final String ERROR_IMPORT_MISSING_SITE_ID = "Site ID is missing. Please click on Generate Site ID button on your sales form.";
	public static final String ERROR_IMPORT_COUNTRY_NOT_RECOGNIZED = "Country not recognized";
	public static final String ERROR_IMPORT_INVALID_DIVERSITY_FORMAT = "Invalid Diversity Format (Site Id-Diversity Code [A, B, or C])";
	public static final String ERROR_PORT_SPEED_GREATER_THAN_CIRCUIT_SPEED = "Port Speed should be less than or equal to Access Speed";
	public static final String ERROR_PORT_INVALID_DIVERSITY_SAME_SITE = "Invalid Diversity Option: Cannot assign diversity to the same site.";
	public static final String ERROR_PORT_INVALID_DIVERSITY_INVALID_SITE_ID = "Invalid Diversity Option: Diversity Site ID does not exist.";
	public static final String ERROR_FULL_ACCESS_UPSPEED = "Up Speed needs to be empty if Full Access is requested.";
	public static final String ERROR_DUPLICATE_SITE_ID = "Duplicate Site IDs detected. Please re-check the sales form.";
	
    public static final String ERROR_PRODUCT_TYPE_P2P = "Product Type P2P is only for Virtela Mpls";
    public static final String ERROR_NULL_TERMINATING_SITE = "Terminating Site ID is required for P2P";
    public static final String ERROR_TERMINATED_TO_ITSELF = "Site is terminated to itself. Please check your Terminating Site ID.";
    
    public static final String ERROR_MISSING_P2P_PARTNER = " is part of a P2P Offnet network in the parent project & should always be launched in pair. Please add the other site of the P2P Offnet pair from the Line Ids.";
    public static final String ERROR_MISSING_MULTIHOP_MASTER = " is part of a Multihop P2P network in the parent project & Master Site is not added in the project. Please add the master site of the network.";
    public static final String ERROR_MISSING_MULTIHOP_SLAVE = " is part of a Multihop P2P network in the parent project & Slave Site is not added in the project. Please add at least 1 slave site of the network.";
    public static final String ERROR_MISSING_DIVERSITY = " is part of a Diversity request in the parent project & should always be launched in diversity pair in the project. Please add the other Site of the Diversity pair & then remove the Diversity Code & Diversity Site Id from the Line Ids.";
    public static final String ERROR_MISSING_DIVERSITY_LAUNCH = " is part of a Diversity request in the project & should always be launched in diversity pair in the project. Please select the other Site of the Diversity pair.";
    
    public static final String ERROR_MIN_LIMIT_BGP_ROUTES = "Number of BGP Routes cannot be in negative value.";
    
	/* ---------------------------- CHANGE REQUESTS ------------------------------------- */
	public static final String ERROR_CHANGE_REQUEST_INVALID_TYPE = "Change Type is invalid. No Change Request has been sent.";
	public static final String ERROR_CHANGE_REQUEST_INVALID_LEVEL = "Change Level is invalid. No Change Request has been sent.";
	public static final String ERROR_CHANGE_REQUEST_INVALID_FIELD = "Change Field is invalid. No Change Request has been sent.";
	public static final String ERROR_CHANGE_REQUEST_INVALID_SALES_REF = "No Sales Project Reference Found. No Change Request has been sent.";
	
	/* ---------------------------- NCOP ITEM/PROJECT  ------------------------------------- */
	public static final String ERROR_NCOP_PROJECT_NOT_FOUND = "NCOP Project Does Not Exist.";
	public static final String ERROR_NCOP_ITEM_NOT_FOUND = "NCOP Item Does Not Exist.";
	public static final String ERROR_NCOP_EMPTY_ITEM_LIST = "Cannot proceed. Please send at least 1 NCOP item.";
	public static final String ERROR_NCOP_PROJECT_ALREADY_CLEAN = "NCOP Project does not need any clarification.";
	public static final String ERROR_NCOP_PROJECT_ALREADY_FOR_CLARIFICATION = "Clarification has already been sent. Please wait for Virtela Pricing Manager's response.";
	
	/* ---------------------------- NOTES ------------------------------------- */
	public static final String ERROR_INVALID_NOTE_TYPE_PARAM = " is invalid Note Type.";
	public static final String ERROR_NOTE_UPDATE_NOT_ALLOWED = "Note is not allowed to be updated.";
	public static final String ERROR_INVALID_NOTIFICATION_TYPE = "The notification type you sent is invalid.";
	public static final String ERROR_CATEGORY_NOTE_REQUIRED = "Category in notes is required to proceed.";
	
	/* ---------------------------- PRICING/ADDRESS VALIDATION ------------------------------------- */
	public static final String ERROR_NO_ADDRESS_SUGGESTION_FOUND = "No Address Suggestion found";
	public static final String ERROR_COUNTRY_CODE_REQUIRED = "Country code is required for address validation";
	public static final String ERROR_SELECT_SOURCE = "Select at least one of the following sources: NDA, Melissa or Google.";
	public static final String ERROR_INVALID_CURRENCY_CODE_FOUND = "Invalid currency code was supplied.";
	public static final String ERROR_NO_LOOKUP_TYPE_SELECTED = "Please select atleast one pricing source: Vendor API, Cost Table, Historical, Historical Exact";
	
	/* ---------------------------- OTHERS PSP RELATED ------------------------------------- */
	public static final String ERROR_AFFILIATE_IN_USE = "Affiliate is Already in Use";
	
	/* ---------------------------- FILE MANAGEMENT ------------------------------------- */
	public static final String ERROR_NFS_DIR_MISSING = "Cannot connect to file server, please contact Manila Systems Team";
	public static final String ERROR_FAIED_TO_UPLOAD_FILE = "File upload failed";
	public static final String ERROR_FILE_ALREADY_EXIST = "File you are trying to upload alead exsit";
	public static final String ERROR_FILE_NOT_FOUND = "File not Found";
	public static final String ERROR_INVALID_DOCUMENT_TYPE = "Invalid Document Type";
	public static final String ERROR_INVALID_FILE_TYPE = "Uploaded file type is not supported.";
	private static final String ERROR_FILE_SIZE_EXCEED = "Uploaded filesize has exceeded the VALUE_ONE mb limit";
	public static final String ERROR_GENERATING_EXPORT = "Failed to generate requested file.";
	
	/* ---------------------------- CIF RELATED ------------------------------------- */
	public static final String ERROR_CIF_ALREADY_EXIST = "Initial Generated CIF File exists,Please try to upload another version.";
	public static final String ERROR_CIF_GENERATE_FAILED = "Failed to generate CIF.";
	public static final String ERROR_CIF_QUOTEID_NOT_MATCH = "Quote Id not match.";
	
	public static final String ERROR_NO_VCID_MATCH = "Cannot pull VCID information based on NTT Circuit Offered.";
	
	// MSG Keys
	private static final String KEY_ONE = "VALUE_ONE";
	public static final String REJECT_CANCEL_REQUEST = "Request to cancel is rejected";
	
	public static final String getFileSeizeExceededMsg() {
		return ERROR_FILE_SIZE_EXCEED.replace(KEY_ONE, Constants.MB_FILE_SIZE_LIMIT.toString());
	}
	
	// AVP RELATED
	public static final String TERM_24_DISCOUNT = "Discount for 24 Months Term is Required";
	public static final String TERM_36_DISCOUNT ="Discount for 36 Months Term is Required";
	public static final String TERM_24 = "24 Months Term: ";
	public static final String TERM_36 = "36 Months Term: ";
	public static final String ERROR_TERM_OFF = "Term can't be Used , default flag is off";
	public static final String ERROR_TERM_UNDIFINED = "Term is not Defined";
	public static final String ERROR_MISMATCH_CURRENCY = "Please use currency declared in AVP";
	
	//JSON format messages
	public static final String JSON_INFO_UPDATE_SUCCESS = "{\"message\" : \""+INFO_UPDATE_SUCCESS+"\"}";
	public static final String JSON_INFO_INSERT_SUCCESS = "{\"message\" : \""+INFO_INSERT_SUCCESS+"\"}";
	
}
