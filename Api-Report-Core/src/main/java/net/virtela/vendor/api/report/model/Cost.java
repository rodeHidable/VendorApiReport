package net.virtela.vendor.api.report.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cost {

	private long accessQuoteBasketId;
	private String accessManager;
	private Long accessProductID;
	private String accessType;
	private String active;
	private String amSolution;
	private String autoClosed;
	private String avmProviderID;
	private String circuitHandoff;
	private Long circuitPortSpeed;
	private String circuitSpeed;
	private String circuitTerm;
	private String cityUpper;
	private String comments;
	private String currency;
	private Timestamp dateQuoteCreated;
	private String incompleteFlag;
	private String incompleteQuote;
	private String lastMileVendor;
	private Timestamp lastModDate;
	private Long leadTime;
	private Long localLoopMrcFx;
	private Long localLoopMrcUsd;
	private Long localLoopNrcFx;
	private Long localLoopNrcUsd;
	private String mapToTerm;
	private Long marketRateMrc;
	private Long marketRateNrc;
	private String marketRateQuoteRefId;
	private String marketRateSource;
	private String notForAutoClose;
	private Long portLoopMrcFx;
	private Long portLoopMrcUsd;
	private Long portLoopNrcFx;
	private Long portLoopNrcUsd;
	private String primaryFlag;
	private String provider;
	private String qbCity;
	private String qbCountry;
	private String qbPhoneNumber;
	private String qbState;
	private String qbStreetAddress;
	private String qbStreetAddressSecondary;
	private String qbType;
	private String qbZip;
	private Long quoteID;
	private String quoteSource;
	private String region;
	private String solutionFlag;
	private String tag;
	private Long upSpeed;
	private String vcid;
	private String virtelaLcc;
	private String virtelaProduct;
	private Long virtelaProductID;
	private Long referenceQuoteID;
	private String projectID;
	private String customerIf;
	private String qosType;
	private String jumboFrame;
	private Long bgpRoutes;
	private Long multiVrf;
	private String multiCast;
	private Long ipDualStack;
	private String quoteSubType;
	private Double vatRate;
	private Long vatMrcFx;
	private Long vatNrcFx;
	private Long xcVendorProductId;
	private String xcType;
	private Long xcMrcFx;
	private Long xcNrcFx;
	private Long totalMrcFx;
	private Long totalNrcFx;
	private Long totalMrcUsd;
	private Long totalNrcUsd;
	private Long productOptionId;
	private String cpeType;
	private Long ipAddMrcFx;
	private Long ipAddNrcFx;
	private Long pstnBhMrcFx;
	private Long pstnBhNrcFx;
	private Long vrfMrcFx;
	private Long vrfNrcFx;
	private Long bgpRoutingUnitMrc;
	private String expediteFlag;
	private Long expediteNrc;
	private String disconnectFlag;
	private Long disconnectAdminNrc;
	private Integer cpeFlag;
	private Long cpeMrcFx;
	private Long cpeNrcFx;
	private String standardTestFlag;
	private Long standardTestNrc;
	private Long nonBhNrc;
	private Long etlNrc;
	private Long buildNrcFx;
	private Long preQualificationNrc;
	private String avpNocSupport;
	private String subnetMask;
	private Long extraIpNrc;
	private Long extraIpMrc;
	private Long vatTotalMrcFx;
	private Long vatTotalNrcFx;
	private Long licenseFeeMrcFx;
	private Long licenseFeeNrcFx = 0l;
	private Double latitude;
	private Double longitude;
	private Double vatPercentage;
	private String accessProduct;
	private Long mrcDiscount;
	private Long nrcDiscount;
	private String vendorRefCode;
	private String lookupCode;
	private String xcAvpName;
	private String avpApiQuoteSource;
	private boolean fromApiFramework;
	private String avpCapacityTagName;
	private String avpCapacityTagDescription;
	private String cpeDescription;

	public long getAccessQuoteBasketId() {
		return this.accessQuoteBasketId;
	}

	public void setAccessQuoteBasketId(long accessQuoteBasketId) {
		this.accessQuoteBasketId = accessQuoteBasketId;
	}

	public String getAccessManager() {
		return this.accessManager;
	}

	public void setAccessManager(String accessManager) {
		this.accessManager = accessManager;
	}

	public Long getAccessProductID() {
		return this.accessProductID;
	}

	public void setAccessProductID(Long accessProductID) {
		this.accessProductID = accessProductID;
	}

	public String getAccessType() {
		return this.accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAmSolution() {
		return this.amSolution;
	}

	public void setAmSolution(String amSolution) {
		this.amSolution = amSolution;
	}

	public String getAutoClosed() {
		return this.autoClosed;
	}

	public void setAutoClosed(String autoClosed) {
		this.autoClosed = autoClosed;
	}

	public String getAvmProviderID() {
		return this.avmProviderID;
	}

	public void setAvmProviderID(String avmProviderID) {
		this.avmProviderID = avmProviderID;
	}

	public String getCircuitHandoff() {
		return this.circuitHandoff;
	}

	public void setCircuitHandoff(String circuitHandoff) {
		this.circuitHandoff = circuitHandoff;
	}

	public Long getCircuitPortSpeed() {
		return this.circuitPortSpeed;
	}

	public void setCircuitPortSpeed(Long circuitPortSpeed) {
		this.circuitPortSpeed = circuitPortSpeed;
	}

	public String getCircuitSpeed() {
		return this.circuitSpeed;
	}

	public void setCircuitSpeed(String circuitSpeed) {
		this.circuitSpeed = circuitSpeed;
	}

	public String getCircuitTerm() {
		return this.circuitTerm;
	}

	public void setCircuitTerm(String circuitTerm) {
		this.circuitTerm = circuitTerm;
	}

	public String getCityUpper() {
		return this.cityUpper;
	}

	public void setCityUpper(String cityUpper) {
		this.cityUpper = cityUpper;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getDateQuoteCreated() {
		return this.dateQuoteCreated;
	}

	public void setDateQuoteCreated(Timestamp dateQuoteCreated) {
		this.dateQuoteCreated = dateQuoteCreated;
	}

	public String getIncompleteFlag() {
		return this.incompleteFlag;
	}

	public void setIncompleteFlag(String incompleteFlag) {
		this.incompleteFlag = incompleteFlag;
	}

	public String getIncompleteQuote() {
		return this.incompleteQuote;
	}

	public void setIncompleteQuote(String incompleteQuote) {
		this.incompleteQuote = incompleteQuote;
	}

	public String getLastMileVendor() {
		return this.lastMileVendor;
	}

	public void setLastMileVendor(String lastMileVendor) {
		this.lastMileVendor = lastMileVendor;
	}

	public Timestamp getLastModDate() {
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getLeadTime() {
		return this.leadTime;
	}

	public void setLeadTime(Long leadTime) {
		this.leadTime = leadTime;
	}

	public Long getLocalLoopMrcFx() {
		return this.localLoopMrcFx;
	}

	public void setLocalLoopMrcFx(Long localLoopMrcFx) {
		this.localLoopMrcFx = localLoopMrcFx;
	}

	public Long getLocalLoopMrcUsd() {
		return this.localLoopMrcUsd;
	}

	public void setLocalLoopMrcUsd(Long localLoopMrcUsd) {
		this.localLoopMrcUsd = localLoopMrcUsd;
	}

	public Long getLocalLoopNrcFx() {
		return this.localLoopNrcFx;
	}

	public void setLocalLoopNrcFx(Long localLoopNrcFx) {
		this.localLoopNrcFx = localLoopNrcFx;
	}

	public Long getLocalLoopNrcUsd() {
		return this.localLoopNrcUsd;
	}

	public void setLocalLoopNrcUsd(Long localLoopNrcUsd) {
		this.localLoopNrcUsd = localLoopNrcUsd;
	}

	public String getMapToTerm() {
		return this.mapToTerm;
	}

	public void setMapToTerm(String mapToTerm) {
		this.mapToTerm = mapToTerm;
	}

	public Long getMarketRateMrc() {
		return this.marketRateMrc;
	}

	public void setMarketRateMrc(Long marketRateMrc) {
		this.marketRateMrc = marketRateMrc;
	}

	public Long getMarketRateNrc() {
		return this.marketRateNrc;
	}

	public void setMarketRateNrc(Long marketRateNrc) {
		this.marketRateNrc = marketRateNrc;
	}

	public String getMarketRateQuoteRefId() {
		return this.marketRateQuoteRefId;
	}

	public void setMarketRateQuoteRefId(String marketRateQuoteRefId) {
		this.marketRateQuoteRefId = marketRateQuoteRefId;
	}

	public String getMarketRateSource() {
		return this.marketRateSource;
	}

	public void setMarketRateSource(String marketRateSource) {
		this.marketRateSource = marketRateSource;
	}

	public String getNotForAutoClose() {
		return this.notForAutoClose;
	}

	public void setNotForAutoClose(String notForAutoClose) {
		this.notForAutoClose = notForAutoClose;
	}

	public Long getPortLoopMrcFx() {
		return this.portLoopMrcFx;
	}

	public void setPortLoopMrcFx(Long portLoopMrcFx) {
		this.portLoopMrcFx = portLoopMrcFx;
	}

	public Long getPortLoopMrcUsd() {
		return this.portLoopMrcUsd;
	}

	public void setPortLoopMrcUsd(Long portLoopMrcUsd) {
		this.portLoopMrcUsd = portLoopMrcUsd;
	}

	public Long getPortLoopNrcFx() {
		return this.portLoopNrcFx;
	}

	public void setPortLoopNrcFx(Long portLoopNrcFx) {
		this.portLoopNrcFx = portLoopNrcFx;
	}

	public Long getPortLoopNrcUsd() {
		return this.portLoopNrcUsd;
	}

	public void setPortLoopNrcUsd(Long portLoopNrcUsd) {
		this.portLoopNrcUsd = portLoopNrcUsd;
	}

	public String getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getQbCity() {
		return this.qbCity;
	}

	public void setQbCity(String qbCity) {
		this.qbCity = qbCity;
	}

	public String getQbCountry() {
		return this.qbCountry;
	}

	public void setQbCountry(String qbCountry) {
		this.qbCountry = qbCountry;
	}

	public String getQbPhoneNumber() {
		return this.qbPhoneNumber;
	}

	public void setQbPhoneNumber(String qbPhoneNumber) {
		this.qbPhoneNumber = qbPhoneNumber;
	}

	public String getQbState() {
		return this.qbState;
	}

	public void setQbState(String qbState) {
		this.qbState = qbState;
	}

	public String getQbStreetAddress() {
		return this.qbStreetAddress;
	}

	public void setQbStreetAddress(String qbStreetAddress) {
		this.qbStreetAddress = qbStreetAddress;
	}

	public String getQbStreetAddressSecondary() {
		return this.qbStreetAddressSecondary;
	}

	public void setQbStreetAddressSecondary(String qbStreetAddressSecondary) {
		this.qbStreetAddressSecondary = qbStreetAddressSecondary;
	}

	public String getQbType() {
		return this.qbType;
	}

	public void setQbType(String qbType) {
		this.qbType = qbType;
	}

	public String getQbZip() {
		return this.qbZip;
	}

	public void setQbZip(String qbZip) {
		this.qbZip = qbZip;
	}

	public Long getQuoteID() {
		return this.quoteID;
	}

	public void setQuoteID(Long quoteID) {
		this.quoteID = quoteID;
	}

	public String getQuoteSource() {
		return this.quoteSource;
	}

	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSolutionFlag() {
		return this.solutionFlag;
	}

	public void setSolutionFlag(String solutionFlag) {
		this.solutionFlag = solutionFlag;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getUpSpeed() {
		return this.upSpeed;
	}

	public void setUpSpeed(Long upSpeed) {
		this.upSpeed = upSpeed;
	}

	public String getVcid() {
		return this.vcid;
	}

	public void setVcid(String vcid) {
		this.vcid = vcid;
	}

	public String getVirtelaLcc() {
		return this.virtelaLcc;
	}

	public void setVirtelaLcc(String virtelaLcc) {
		this.virtelaLcc = virtelaLcc;
	}

	public String getVirtelaProduct() {
		return this.virtelaProduct;
	}

	public void setVirtelaProduct(String virtelaProduct) {
		this.virtelaProduct = virtelaProduct;
	}

	public Long getVirtelaProductID() {
		return this.virtelaProductID;
	}

	public void setVirtelaProductID(Long virtelaProductID) {
		this.virtelaProductID = virtelaProductID;
	}

	public Long getReferenceQuoteID() {
		return this.referenceQuoteID;
	}

	public void setReferenceQuoteID(Long referenceQuoteID) {
		this.referenceQuoteID = referenceQuoteID;
	}

	public String getProjectID() {
		return this.projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getCustomerIf() {
		return this.customerIf;
	}

	public void setCustomerIf(String customerIf) {
		this.customerIf = customerIf;
	}

	public String getQosType() {
		return this.qosType;
	}

	public void setQosType(String qosType) {
		this.qosType = qosType;
	}

	public String getJumboFrame() {
		return this.jumboFrame;
	}

	public void setJumboFrame(String jumboFrame) {
		this.jumboFrame = jumboFrame;
	}

	public Long getBgpRoutes() {
		return this.bgpRoutes;
	}

	public void setBgpRoutes(Long bgpRoutes) {
		this.bgpRoutes = bgpRoutes;
	}

	public Long getMultiVrf() {
		return this.multiVrf;
	}

	public void setMultiVrf(Long multiVrf) {
		this.multiVrf = multiVrf;
	}

	public String getMultiCast() {
		return this.multiCast;
	}

	public void setMultiCast(String multiCast) {
		this.multiCast = multiCast;
	}

	public Long getIpDualStack() {
		return this.ipDualStack;
	}

	public void setIpDualStack(Long ipDualStack) {
		this.ipDualStack = ipDualStack;
	}

	public String getQuoteSubType() {
		return this.quoteSubType;
	}

	public void setQuoteSubType(String quoteSubType) {
		this.quoteSubType = quoteSubType;
	}

	public Double getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(Double vatRate) {
		this.vatRate = vatRate;
	}

	public Long getVatMrcFx() {
		return this.vatMrcFx;
	}

	public void setVatMrcFx(Long vatMrcFx) {
		this.vatMrcFx = vatMrcFx;
	}

	public Long getVatNrcFx() {
		return this.vatNrcFx;
	}

	public void setVatNrcFx(Long vatNrcFx) {
		this.vatNrcFx = vatNrcFx;
	}

	public Long getXcVendorProductId() {
		return this.xcVendorProductId;
	}

	public void setXcVendorProductId(Long xcVendorProductId) {
		this.xcVendorProductId = xcVendorProductId;
	}

	public String getXcType() {
		return this.xcType;
	}

	public void setXcType(String xcType) {
		this.xcType = xcType;
	}

	public Long getXcMrcFx() {
		return this.xcMrcFx;
	}

	public void setXcMrcFx(Long xcMrcFx) {
		this.xcMrcFx = xcMrcFx;
	}

	public Long getXcNrcFx() {
		return this.xcNrcFx;
	}

	public void setXcNrcFx(Long xcNrcFx) {
		this.xcNrcFx = xcNrcFx;
	}

	public Long getTotalMrcFx() {
		return this.totalMrcFx;
	}

	public void setTotalMrcFx(Long totalMrcFx) {
		this.totalMrcFx = totalMrcFx;
	}

	public Long getTotalNrcFx() {
		return this.totalNrcFx;
	}

	public void setTotalNrcFx(Long totalNrcFx) {
		this.totalNrcFx = totalNrcFx;
	}

	public Long getTotalMrcUsd() {
		return this.totalMrcUsd;
	}

	public void setTotalMrcUsd(Long totalMrcUsd) {
		this.totalMrcUsd = totalMrcUsd;
	}

	public Long getTotalNrcUsd() {
		return this.totalNrcUsd;
	}

	public void setTotalNrcUsd(Long totalNrcUsd) {
		this.totalNrcUsd = totalNrcUsd;
	}

	public Long getProductOptionId() {
		return this.productOptionId;
	}

	public void setProductOptionId(Long productOptionId) {
		this.productOptionId = productOptionId;
	}

	public String getCpeType() {
		return this.cpeType;
	}

	public void setCpeType(String cpeType) {
		this.cpeType = cpeType;
	}

	public Long getIpAddMrcFx() {
		return this.ipAddMrcFx;
	}

	public void setIpAddMrcFx(Long ipAddMrcFx) {
		this.ipAddMrcFx = ipAddMrcFx;
	}

	public Long getIpAddNrcFx() {
		return this.ipAddNrcFx;
	}

	public void setIpAddNrcFx(Long ipAddNrcFx) {
		this.ipAddNrcFx = ipAddNrcFx;
	}

	public Long getPstnBhMrcFx() {
		return this.pstnBhMrcFx;
	}

	public void setPstnBhMrcFx(Long pstnBhMrcFx) {
		this.pstnBhMrcFx = pstnBhMrcFx;
	}

	public Long getPstnBhNrcFx() {
		return this.pstnBhNrcFx;
	}

	public void setPstnBhNrcFx(Long pstnBhNrcFx) {
		this.pstnBhNrcFx = pstnBhNrcFx;
	}

	public Long getVrfMrcFx() {
		return this.vrfMrcFx;
	}

	public void setVrfMrcFx(Long vrfMrcFx) {
		this.vrfMrcFx = vrfMrcFx;
	}

	public Long getVrfNrcFx() {
		return this.vrfNrcFx;
	}

	public void setVrfNrcFx(Long vrfNrcFx) {
		this.vrfNrcFx = vrfNrcFx;
	}

	public Long getBgpRoutingUnitMrc() {
		return this.bgpRoutingUnitMrc;
	}

	public void setBgpRoutingUnitMrc(Long bgpRoutingUnitMrc) {
		this.bgpRoutingUnitMrc = bgpRoutingUnitMrc;
	}

	public String getExpediteFlag() {
		return this.expediteFlag;
	}

	public void setExpediteFlag(String expediteFlag) {
		this.expediteFlag = expediteFlag;
	}

	public Long getExpediteNrc() {
		return this.expediteNrc;
	}

	public void setExpediteNrc(Long expediteNrc) {
		this.expediteNrc = expediteNrc;
	}

	public String getDisconnectFlag() {
		return this.disconnectFlag;
	}

	public void setDisconnectFlag(String disconnectFlag) {
		this.disconnectFlag = disconnectFlag;
	}

	public Long getDisconnectAdminNrc() {
		return this.disconnectAdminNrc;
	}

	public void setDisconnectAdminNrc(Long disconnectAdminNrc) {
		this.disconnectAdminNrc = disconnectAdminNrc;
	}

	public Integer getCpeFlag() {
		return this.cpeFlag;
	}

	public void setCpeFlag(Integer cpeFlag) {
		this.cpeFlag = cpeFlag;
	}

	public Long getCpeMrcFx() {
		return this.cpeMrcFx;
	}

	public void setCpeMrcFx(Long cpeMrcFx) {
		this.cpeMrcFx = cpeMrcFx;
	}

	public Long getCpeNrcFx() {
		return this.cpeNrcFx;
	}

	public void setCpeNrcFx(Long cpeNrcFx) {
		this.cpeNrcFx = cpeNrcFx;
	}

	public String getStandardTestFlag() {
		return this.standardTestFlag;
	}

	public void setStandardTestFlag(String standardTestFlag) {
		this.standardTestFlag = standardTestFlag;
	}

	public Long getStandardTestNrc() {
		return this.standardTestNrc;
	}

	public void setStandardTestNrc(Long standardTestNrc) {
		this.standardTestNrc = standardTestNrc;
	}

	public Long getNonBhNrc() {
		return this.nonBhNrc;
	}

	public void setNonBhNrc(Long nonBhNrc) {
		this.nonBhNrc = nonBhNrc;
	}

	public Long getEtlNrc() {
		return this.etlNrc;
	}

	public void setEtlNrc(Long etlNrc) {
		this.etlNrc = etlNrc;
	}

	public Long getBuildNrcFx() {
		return this.buildNrcFx;
	}

	public void setBuildNrcFx(Long buildNrcFx) {
		this.buildNrcFx = buildNrcFx;
	}

	public Long getPreQualificationNrc() {
		return this.preQualificationNrc;
	}

	public void setPreQualificationNrc(Long preQualificationNrc) {
		this.preQualificationNrc = preQualificationNrc;
	}

	public String getAvpNocSupport() {
		return this.avpNocSupport;
	}

	public void setAvpNocSupport(String avpNocSupport) {
		this.avpNocSupport = avpNocSupport;
	}

	public String getSubnetMask() {
		return this.subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public Long getExtraIpNrc() {
		return this.extraIpNrc;
	}

	public void setExtraIpNrc(Long extraIpNrc) {
		this.extraIpNrc = extraIpNrc;
	}

	public Long getExtraIpMrc() {
		return this.extraIpMrc;
	}

	public void setExtraIpMrc(Long extraIpMrc) {
		this.extraIpMrc = extraIpMrc;
	}

	public Long getVatTotalMrcFx() {
		return this.vatTotalMrcFx;
	}

	public void setVatTotalMrcFx(Long vatTotalMrcFx) {
		this.vatTotalMrcFx = vatTotalMrcFx;
	}

	public Long getVatTotalNrcFx() {
		return this.vatTotalNrcFx;
	}

	public void setVatTotalNrcFx(Long vatTotalNrcFx) {
		this.vatTotalNrcFx = vatTotalNrcFx;
	}

	public Long getLicenseFeeMrcFx() {
		return this.licenseFeeMrcFx;
	}

	public void setLicenseFeeMrcFx(Long licenseFeeMrcFx) {
		this.licenseFeeMrcFx = licenseFeeMrcFx;
	}

	public Long getLicenseFeeNrcFx() {
		return this.licenseFeeNrcFx;
	}

	public void setLicenseFeeNrcFx(Long licenseFeeNrcFx) {
		this.licenseFeeNrcFx = licenseFeeNrcFx;
	}

	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getVatPercentage() {
		return this.vatPercentage;
	}

	public void setVatPercentage(Double vatPercentage) {
		this.vatPercentage = vatPercentage;
	}

	public String getAccessProduct() {
		return this.accessProduct;
	}

	public void setAccessProduct(String accessProduct) {
		this.accessProduct = accessProduct;
	}

	public Long getMrcDiscount() {
		return this.mrcDiscount;
	}

	public void setMrcDiscount(Long mrcDiscount) {
		this.mrcDiscount = mrcDiscount;
	}

	public Long getNrcDiscount() {
		return this.nrcDiscount;
	}

	public void setNrcDiscount(Long nrcDiscount) {
		this.nrcDiscount = nrcDiscount;
	}

	public String getVendorRefCode() {
		return this.vendorRefCode;
	}

	public void setVendorRefCode(String vendorRefCode) {
		this.vendorRefCode = vendorRefCode;
	}

	public String getLookupCode() {
		return this.lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getXcAvpName() {
		return this.xcAvpName;
	}

	public void setXcAvpName(String xcAvpName) {
		this.xcAvpName = xcAvpName;
	}

	public String getAvpApiQuoteSource() {
		return this.avpApiQuoteSource;
	}

	public void setAvpApiQuoteSource(String avpApiQuoteSource) {
		this.avpApiQuoteSource = avpApiQuoteSource;
	}

	public boolean isFromApiFramework() {
		return this.fromApiFramework;
	}

	public void setFromApiFramework(boolean fromApiFramework) {
		this.fromApiFramework = fromApiFramework;
	}

	public String getAvpCapacityTagName() {
		return this.avpCapacityTagName;
	}

	public void setAvpCapacityTagName(String avpCapacityTagName) {
		this.avpCapacityTagName = avpCapacityTagName;
	}

	public String getAvpCapacityTagDescription() {
		return this.avpCapacityTagDescription;
	}

	public void setAvpCapacityTagDescription(String avpCapacityTagDescription) {
		this.avpCapacityTagDescription = avpCapacityTagDescription;
	}

	public String getCpeDescription() {
		return this.cpeDescription;
	}

	public void setCpeDescription(String cpeDescription) {
		this.cpeDescription = cpeDescription;
	}

	@Override
	public String toString() {
		return "Cost [accessQuoteBasketId=" + this.accessQuoteBasketId + ", accessManager=" + this.accessManager
				+ ", accessProductID=" + this.accessProductID + ", accessType=" + this.accessType + ", active="
				+ this.active + ", amSolution=" + this.amSolution + ", autoClosed=" + this.autoClosed
				+ ", avmProviderID=" + this.avmProviderID + ", circuitHandoff=" + this.circuitHandoff
				+ ", circuitPortSpeed=" + this.circuitPortSpeed + ", circuitSpeed=" + this.circuitSpeed
				+ ", circuitTerm=" + this.circuitTerm + ", cityUpper=" + this.cityUpper + ", comments=" + this.comments
				+ ", currency=" + this.currency + ", dateQuoteCreated=" + this.dateQuoteCreated + ", incompleteFlag="
				+ this.incompleteFlag + ", incompleteQuote=" + this.incompleteQuote + ", lastMileVendor="
				+ this.lastMileVendor + ", lastModDate=" + this.lastModDate + ", leadTime=" + this.leadTime
				+ ", localLoopMrcFx=" + this.localLoopMrcFx + ", localLoopMrcUsd=" + this.localLoopMrcUsd
				+ ", localLoopNrcFx=" + this.localLoopNrcFx + ", localLoopNrcUsd=" + this.localLoopNrcUsd
				+ ", mapToTerm=" + this.mapToTerm + ", marketRateMrc=" + this.marketRateMrc + ", marketRateNrc="
				+ this.marketRateNrc + ", marketRateQuoteRefId=" + this.marketRateQuoteRefId + ", marketRateSource="
				+ this.marketRateSource + ", notForAutoClose=" + this.notForAutoClose + ", portLoopMrcFx="
				+ this.portLoopMrcFx + ", portLoopMrcUsd=" + this.portLoopMrcUsd + ", portLoopNrcFx="
				+ this.portLoopNrcFx + ", portLoopNrcUsd=" + this.portLoopNrcUsd + ", primaryFlag=" + this.primaryFlag
				+ ", provider=" + this.provider + ", qbCity=" + this.qbCity + ", qbCountry=" + this.qbCountry
				+ ", qbPhoneNumber=" + this.qbPhoneNumber + ", qbState=" + this.qbState + ", qbStreetAddress="
				+ this.qbStreetAddress + ", qbStreetAddressSecondary=" + this.qbStreetAddressSecondary + ", qbType="
				+ this.qbType + ", qbZip=" + this.qbZip + ", quoteID=" + this.quoteID + ", quoteSource="
				+ this.quoteSource + ", region=" + this.region + ", solutionFlag=" + this.solutionFlag + ", tag="
				+ this.tag + ", upSpeed=" + this.upSpeed + ", vcid=" + this.vcid + ", virtelaLcc=" + this.virtelaLcc
				+ ", virtelaProduct=" + this.virtelaProduct + ", virtelaProductID=" + this.virtelaProductID
				+ ", referenceQuoteID=" + this.referenceQuoteID + ", projectID=" + this.projectID + ", customerIf="
				+ this.customerIf + ", qosType=" + this.qosType + ", jumboFrame=" + this.jumboFrame + ", bgpRoutes="
				+ this.bgpRoutes + ", multiVrf=" + this.multiVrf + ", multiCast=" + this.multiCast + ", ipDualStack="
				+ this.ipDualStack + ", quoteSubType=" + this.quoteSubType + ", vatRate=" + this.vatRate + ", vatMrcFx="
				+ this.vatMrcFx + ", vatNrcFx=" + this.vatNrcFx + ", xcVendorProductId=" + this.xcVendorProductId
				+ ", xcType=" + this.xcType + ", xcMrcFx=" + this.xcMrcFx + ", xcNrcFx=" + this.xcNrcFx
				+ ", totalMrcFx=" + this.totalMrcFx + ", totalNrcFx=" + this.totalNrcFx + ", totalMrcUsd="
				+ this.totalMrcUsd + ", totalNrcUsd=" + this.totalNrcUsd + ", productOptionId=" + this.productOptionId
				+ ", cpeType=" + this.cpeType + ", ipAddMrcFx=" + this.ipAddMrcFx + ", ipAddNrcFx=" + this.ipAddNrcFx
				+ ", pstnBhMrcFx=" + this.pstnBhMrcFx + ", pstnBhNrcFx=" + this.pstnBhNrcFx + ", vrfMrcFx="
				+ this.vrfMrcFx + ", vrfNrcFx=" + this.vrfNrcFx + ", bgpRoutingUnitMrc=" + this.bgpRoutingUnitMrc
				+ ", expediteFlag=" + this.expediteFlag + ", expediteNrc=" + this.expediteNrc + ", disconnectFlag="
				+ this.disconnectFlag + ", disconnectAdminNrc=" + this.disconnectAdminNrc + ", cpeFlag=" + this.cpeFlag
				+ ", cpeMrcFx=" + this.cpeMrcFx + ", cpeNrcFx=" + this.cpeNrcFx + ", standardTestFlag="
				+ this.standardTestFlag + ", standardTestNrc=" + this.standardTestNrc + ", nonBhNrc=" + this.nonBhNrc
				+ ", etlNrc=" + this.etlNrc + ", buildNrcFx=" + this.buildNrcFx + ", preQualificationNrc="
				+ this.preQualificationNrc + ", avpNocSupport=" + this.avpNocSupport + ", subnetMask=" + this.subnetMask
				+ ", extraIpNrc=" + this.extraIpNrc + ", extraIpMrc=" + this.extraIpMrc + ", vatTotalMrcFx="
				+ this.vatTotalMrcFx + ", vatTotalNrcFx=" + this.vatTotalNrcFx + ", licenseFeeMrcFx="
				+ this.licenseFeeMrcFx + ", licenseFeeNrcFx=" + this.licenseFeeNrcFx + ", latitude=" + this.latitude
				+ ", longitude=" + this.longitude + ", vatPercentage=" + this.vatPercentage + ", accessProduct="
				+ this.accessProduct + ", mrcDiscount=" + this.mrcDiscount + ", nrcDiscount=" + this.nrcDiscount
				+ ", vendorRefCode=" + this.vendorRefCode + ", lookupCode=" + this.lookupCode + ", xcAvpName="
				+ this.xcAvpName + ", avpApiQuoteSource=" + this.avpApiQuoteSource + ", fromApiFramework="
				+ this.fromApiFramework + ", avpCapacityTagName=" + this.avpCapacityTagName
				+ ", avpCapacityTagDescription=" + this.avpCapacityTagDescription + ", cpeDescription="
				+ this.cpeDescription + "]";
	}

}
