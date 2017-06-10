package org.jimmutable.adpanda.facebook;

import org.jimmutable.adpanda.facebook.APISecrets.Key;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.APIRequestGetAds;


//Examples can be found in the GIT hub repository: https://github.com/facebook/facebook-java-ads-sdk

public class TestApp 
{
	static public void main(String args[]) throws Exception
	{
		String access_token = APISecrets.getSecret(Key.ACCESS_TOKEN, null);
		String app_secret = APISecrets.getSecret(Key.APP_SECRET, null);
		String accound_id = APISecrets.getSecret(Key.AD_ACCOUNT_ID, null);
		
		
		APIContext context = new APIContext(access_token, app_secret).enableDebug(true);
		
		AdAccount account = new AdAccount(accound_id, context);
		
		account.getAds().execute();
	}
}
