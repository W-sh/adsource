package com.ad.biz.source.apihandler.staapi;

public class PartnerBasic {
	 public final int AGENT_TYPE;

	    public final int PARTNER_ID;

	    public final String AD_CACHE_PG_COUNTRY_KEY;

	    public final String PARTNER_STR;

	    public final String CACHE_CURVERSION_KEY;

	    public final String CACHE_CURVERSION_GUID_KEY;

	    public final String CACHE_USER_REQ_KEY;

	    public final String CUR_ECPU_KEY;

	    public final String CUR_CAMPAIGNCONVERSION_KEY;

	    public final String CUR_INSTALLCOV_KEY;

	    public final String CUR_INSTALL_KEY;

	    public final String CUR_GPANALYSIS_KEY;

	    public final String AD_CACHE_KEY;

	    public final String AD_CACHE_MAP_KEY;
	    public final String AD_FILTER_MAP_KEY;

	    public final String AD_COUNTRY_TAG_KEY;

	    public final String AD_TYPE_TAG_KEY;

	    public final String AD_GPPACKAGE_BUCKET_KEY;

	    public final String AD_INSTALL_KEY;

	    public final String AD_GPANALYSIS_KEY;
	    /**
	     * 以我们自己的campaign id为field，存储对应partner campaign id
	     */
	    public final String AD_CAMPAIGNID_KEY;
	    /**
	     * 以包名标签，里面内容存储对应campaign id
	     */
	    // public final String AD_PKG_TAG_KEY;

	    public static final String ADEX_V3_LOG = "adex:v3:log:";
	    public static final String ADEX_V3_DATA = "adex:v3:data:";
	    public static final String ADEX_V3_ECPU = "adex:v3:ecpu:";
	    public static final String ADEX_V3_CACHE = "adex:v3:agent:";

	    public static final String SUB_V1_DATA = "sub:v1:data:";
	    public static final String SUB_V1_CACHE = "sub:v1:agent:";

	    public final String SUB_PARTNER_KEY;

	    public final String ADEX_V3_PARTNER_KEY;

	    public final String ADEX_V3_CONTENT_HASH_KEY;
	    public final String ADEX_V3_FILTER_HASH_KEY;

	    public final String ADEX_V3_PKG_GP_KEY;

	    public final String ADEX_V3_COUNTRY_TAG_KEY;
	    public final String ADEX_V3_TYPE_TAG_KEY;

	    public final String ADEX_SUB_ID_KEY;

	    public final String ADEX_SUB_CAMPAIGN;

	    public final String ADEX_SUB_CLICKNUM;// 记录campaign当天点击次数

	    public final String ADEX_SUB_BLACK;// 记录campaign哪几天超过cap还是没转化

	    public final String ADEX_SUB_MCCMNC;

	    public final String ADEX_SUB_CARRIER;

	    public final String ADEX_SUB_HALFHOUR_CONV;// 记录分国家何运营商的半小时内转化，用于计算cpc

	    public final String ADEX_SUB_HALFHOUR_CLICK;// 记录分国家何运营商的半小时内点击，用于计算cpc

	    public final String ADEX_SUB_CPC;

	    public final String ADEX_SUB_TODAYCR;

	    public final String ADEX_SUB_BEYONDCR_SET;

	    public final String ADEX_SUB_FILTER;

	    public final String ADEX_SUB_DAY_CONV;// 记录一天offer转化数

	    public final String ADEX_SUB_TAG_COUNTRY_KEY;

	    public final String ADEX_SUB_CACHE_CONV;

	    public final String ADEX_SUB_POSTBACK;

	    public final String ADEX_SUB_UPDATE_OFFER;
	    public final String ADEX_SUB_UPDATE_OFFERV2;

	    public final String ADEX_SUB_OFFERDATA;

	    public PartnerBasic(int partnerId, String partnerStr, int agentType) {
	        this.PARTNER_ID = partnerId;
	        this.PARTNER_STR = partnerStr;
	        this.AGENT_TYPE = agentType;

	        String prefix = "agent:" + this.PARTNER_STR + ":data:";

	        this.AD_CACHE_PG_COUNTRY_KEY = prefix + "adChachePackageGp";

	        this.CACHE_USER_REQ_KEY = prefix + "curUserReq";
	        this.CUR_INSTALL_KEY = prefix + "curInstall";
	        this.CACHE_CURVERSION_KEY = prefix + "curConversion";
	        this.CUR_ECPU_KEY = prefix + "curECPU";

	        this.CACHE_CURVERSION_GUID_KEY = prefix + "curConversionGuidSet";

	        this.CUR_CAMPAIGNCONVERSION_KEY = prefix + "curCampConversion";

	        this.CUR_INSTALLCOV_KEY = prefix + "curINSTCOV";

	        this.CUR_GPANALYSIS_KEY = prefix + "curGpAnalysis";

	        this.AD_CACHE_KEY = prefix + "adContent";

	        this.AD_CAMPAIGNID_KEY = prefix + "campaignId";

	        this.AD_CACHE_MAP_KEY = prefix + "adContentMap";
	        this.AD_FILTER_MAP_KEY = prefix + "adFilterMap";

	        this.AD_GPPACKAGE_BUCKET_KEY = "agent:" + this.PARTNER_STR + ":api:updateAdPackgeGp";

	        this.AD_INSTALL_KEY = prefix + "install";
	        this.AD_GPANALYSIS_KEY = prefix + "gpAnalysis";

	        // this.AD_PKG_TAG_KEY = prefix + "pkgSet{ca" + this.PARTNER_ID + "}:";

	        this.AD_COUNTRY_TAG_KEY = prefix + "tagSet{ca" + this.PARTNER_ID + "}:";
	        this.AD_TYPE_TAG_KEY = prefix + "typeTag{ca" + this.PARTNER_ID + "}:";

	        // ----------------- Adex V3 -----------------
	        this.ADEX_V3_PARTNER_KEY = this.PARTNER_STR + "{kt" + this.PARTNER_ID + "}:";

	        this.ADEX_V3_CONTENT_HASH_KEY = ADEX_V3_CACHE + this.ADEX_V3_PARTNER_KEY + "adContent";
	        this.ADEX_V3_FILTER_HASH_KEY = ADEX_V3_CACHE + this.ADEX_V3_PARTNER_KEY + "adFilter";

	        this.ADEX_V3_PKG_GP_KEY = ADEX_V3_CACHE + this.ADEX_V3_PARTNER_KEY + "adPackageGp";

	        this.ADEX_V3_COUNTRY_TAG_KEY = ADEX_V3_CACHE + this.ADEX_V3_PARTNER_KEY + "countryTag:";
	        this.ADEX_V3_TYPE_TAG_KEY = ADEX_V3_CACHE + this.ADEX_V3_PARTNER_KEY + "typeTag:";

	        // ----------------- Sub订阅 V1 -----------------
	        this.SUB_PARTNER_KEY = this.PARTNER_STR + "{kt" + this.PARTNER_ID + "}:";

	        this.ADEX_SUB_ID_KEY = SUB_V1_CACHE + SUB_PARTNER_KEY + "subId:";
	        this.ADEX_SUB_CAMPAIGN = SUB_V1_CACHE + SUB_PARTNER_KEY + "subCamp";
	        this.ADEX_SUB_MCCMNC = SUB_V1_CACHE + SUB_PARTNER_KEY + "subMccMnc";
	        this.ADEX_SUB_CARRIER = SUB_V1_CACHE + SUB_PARTNER_KEY + "subCarrier";
	        this.ADEX_SUB_DAY_CONV = SUB_V1_CACHE + SUB_PARTNER_KEY + "dayConv:";
	        this.ADEX_SUB_HALFHOUR_CONV = SUB_V1_CACHE + SUB_PARTNER_KEY + "halfHourConv";
	        this.ADEX_SUB_HALFHOUR_CLICK = SUB_V1_CACHE + SUB_PARTNER_KEY + "halfHourClick";

	        this.ADEX_SUB_CPC = SUB_V1_CACHE + SUB_PARTNER_KEY + "cpc";
	        this.ADEX_SUB_FILTER = SUB_V1_CACHE + SUB_PARTNER_KEY + "filter";
	        this.ADEX_SUB_TODAYCR = SUB_V1_CACHE + SUB_PARTNER_KEY + "todayCr:";
	        this.ADEX_SUB_BEYONDCR_SET = SUB_V1_CACHE + SUB_PARTNER_KEY + "beyondCr:";
	        this.ADEX_SUB_TAG_COUNTRY_KEY = SUB_V1_CACHE + SUB_PARTNER_KEY + "countryTag:";
	        this.ADEX_SUB_CACHE_CONV = SUB_V1_CACHE + SUB_PARTNER_KEY + "cacheConv";
	        this.ADEX_SUB_POSTBACK = SUB_V1_CACHE + SUB_PARTNER_KEY + "postback";

	        this.ADEX_SUB_UPDATE_OFFER = SUB_V1_DATA + SUB_PARTNER_KEY + "updateOffer:";

	        this.ADEX_SUB_UPDATE_OFFERV2 = SUB_V1_DATA + SUB_PARTNER_KEY + "updateOfferv2:";

	        this.ADEX_SUB_OFFERDATA = SUB_V1_DATA + SUB_PARTNER_KEY + "offerData:";

	        this.ADEX_SUB_CLICKNUM = SUB_V1_DATA + SUB_PARTNER_KEY + "clickNum:";

	        this.ADEX_SUB_BLACK = SUB_V1_DATA + SUB_PARTNER_KEY + "black";

	    }
	 
}
