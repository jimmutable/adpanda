package org.jimmutable.adpanda.facebook;

import org.jimmutable.adpanda.facebook.APISecrets.Key;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.facebook.ads.sdk.AdCreativeLinkData;
import com.facebook.ads.sdk.AdCreativeObjectStorySpec;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


// Examples can be found in the GIT hub repository: https://github.com/facebook/facebook-java-ads-sdk
// Facebook power editor: https://www.facebook.com/ads/manage/powereditor/manage/ads

public class TestApp 
{
	static public void main(String args[]) throws Exception
	{
		String access_token = APISecrets.getSecret(Key.ACCESS_TOKEN, null);
		String app_secret = APISecrets.getSecret(Key.APP_SECRET, null);
		String accound_id = APISecrets.getSecret(Key.AD_ACCOUNT_ID, null);
		
		
		APIContext context = new APIContext(access_token, app_secret).enableDebug(true);
		
		AdAccount account = new AdAccount(accound_id, context);
		
		/*
		
		APIRequestGetAds request = account.getAds();
		
		request.
		
		
		request = request.requestAccountIdField();
		request = request.requestAdlabelsField();
		request = request.requestNameField();
		
		
		
		APINodeList<Ad> ads = request.execute();
		
		for ( Ad ad : ads )
		{
			System.out.println(ad.getFieldAccountId());
			System.out.println(ad.getFieldName());
			System.out.println(ad.getFieldAdlabels());
			System.out.println(ad.getFieldId());
		}
		*/
		
		/*
		// Get an AD Preview
		{
			// Get an AD by ID
			Ad ad = Ad.fetchById(23842584576570313l, context);
			System.out.println(ad.getFieldName());
			
			AdCreative creative = ad.getFieldCreative().fetch();
			System.out.println(creative.getFieldBody());
			
			APINodeList<AdPreview> adPreviews = creative.getPreviews()
					  .setAdFormat(AdPreview.EnumAdFormat.VALUE_DESKTOP_FEED_STANDARD)
					  .execute();
			
			for ( AdPreview p : adPreviews )
			{
				System.out.println(p.getFieldBody());
			}
		}*/
		
		
		// Test campaign
		/*
		{
			Campaign campaign = account.createCampaign()
		        .setName("Java SDK Test Campaign")
		        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
		        .setSpendCap(10000L)
		        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
		        .execute();
		      System.out.println(campaign);
		      
		      campaign.fetch();
		      
		      System.out.println("Campaign ID: "+campaign.getId());
		      // Campaign ID: 23842589595330313
		}*/
		
		// Test Adset
		/*
		{
			Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList("US")));
			
			AdSet adset = account.createAdSet()
			        .setName("Java SDK Test AdSet")
			        .setCampaignId("23842589595330313")
			        .setStatus(AdSet.EnumStatus.VALUE_PAUSED)
			        .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
			        .setDailyBudget(500L)
			        .setBidAmount(100L)
			        .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_IMPRESSIONS)
			        .setTargeting(targeting)
			        .setRedownload(true)
			        .execute();
			      System.out.println(adset);
			      
			adset.fetch();
			System.out.println("AdSet ID: "+adset.getId());
			// AdSet ID: 23842589595420313
		}*/
		
		// Upload images
		/*{
			 AdImage image = account.createAdImage()
				        .addUploadFile("file", new File("C:\\jimmutable\\adpanda\\test_creative\\small3.jpg"))
				        .execute();
			 
			 System.out.println(image.getFieldHash());
			 
			 
			 // big1.jpg: 76acf10320bfb91c05d59f02a26b7042
			 // big2.jpg: 35fbd0cfbb827722e7cddc8881bf52a8
			 // big3.jpg: e60fab70b21e99fd8f2f56b7dfca3115
			 
			 // small1.jpg: 1804ab4637f6ab35af05f73165b13b95
			 // small2.jpg: 00ee588d39f0c9646cd8a9938fd42d4a
			 // small3.jpg: bdfb3411ac2c7574d43423b5295ab0fe
		}*/
		
		// Create first ad
		/*{
			AdCreative creative = account.createAdCreative()
			        .setTitle("Second API Ad")
			        .setBody("See what Retailer Web Services can do for you")
			        .setImageHash("1804ab4637f6ab35af05f73165b13b95")
			        .setLinkUrl("www.retailerwebservices.com")
			        .setObjectUrl("www.retailerwebservices.com")
			        .execute();
			
			Ad ad = account.createAd()
					.setName("Second API Ad")
					.setAdsetId("23842589595420313")
					.setCreative(creative)
					.setStatus("PAUSED")
					.setBidAmount(100L)
					.setRedownload(true)
					.execute();
		}*/
		
		// Carousel Ad
		{
		
			JsonArray childAttachments = new JsonArray();
	      
			JsonObject attachment1 = new JsonObject();
			attachment1.addProperty("link", "https://www.retailerwebservices.com/slide1.html");
			attachment1.addProperty("description", "www.retailerwebservices.com");
			attachment1.addProperty("image_hash", "1804ab4637f6ab35af05f73165b13b95");
			
			JsonObject attachment2 = new JsonObject();
			attachment2.addProperty("link", "https://www.retailerwebservices.com/slide2.html");
			attachment2.addProperty("description", "www.retailerwebservices.com");
			attachment2.addProperty("image_hash", "00ee588d39f0c9646cd8a9938fd42d4a");
			
			JsonObject attachment3 = new JsonObject();
			attachment3.addProperty("link", "https://www.retailerwebservices.com/slide3.html");
			attachment3.addProperty("description", "www.retailerwebservices.com");
			attachment3.addProperty("image_hash", "bdfb3411ac2c7574d43423b5295ab0fe");
			
			childAttachments.add(attachment1);
			childAttachments.add(attachment2);
			childAttachments.add(attachment3);
			
			String pageID = "1511737035787545"; // This is the "My Test Store" Page ID
	     
			AdCreative creative = account.createAdCreative()
			          .setTitle("First Carousel Creative")
			          .setBody("First Carousel Creative")
			          .setObjectStorySpec(new AdCreativeObjectStorySpec()
			              .setFieldLinkData(new AdCreativeLinkData()
			                   .setFieldChildAttachments(childAttachments.toString())
			                   .setFieldLink("www.example.com"))
			              .setFieldPageId(pageID)
			          )
			          .setLinkUrl("www.example.com")
			          .execute();

			      Ad ad = account.createAd()
			          .setName("First Carousel ad")
			          .setAdsetId("23842589595420313")
			          .setCreative(creative)
			          .setStatus("PAUSED")
			          .setBidAmount(100L)
			          .setRedownload(true)
			          .execute();
		}
	}
}
