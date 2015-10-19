package com.kii.thingifsample.smart_light_demo;

import android.content.Context;

import com.kii.thingif.IoTCloudAPI;
import com.kii.thingif.IoTCloudAPIBuilder;
import com.kii.thingif.Owner;
import com.kii.thingif.schema.SchemaBuilder;
import com.kii.thingifsample.AppConstants;
import com.kii.thingifsample.IoTCloudSampleApplication;

public class ApiBuilder {

    public static IoTCloudAPI buildApi(Context context, Owner owner) {
        String appId = ((IoTCloudSampleApplication) context).getAppId();
        String appKey = ((IoTCloudSampleApplication) context).getAppKey();
        String ioTAppBaseUrl = ((IoTCloudSampleApplication) context).getIoTappBaseUrlAppBaseUrl();
        IoTCloudAPIBuilder builder = IoTCloudAPIBuilder.newBuilder(context, appId,
                appKey, ioTAppBaseUrl, owner);
        SchemaBuilder schemaBuilder = SchemaBuilder.newSchemaBuilder(AppConstants.THING_TYPE,
                AppConstants.SCHEMA_NAME, AppConstants.SCHEMA_VERSION, LightState.class);
        schemaBuilder.addActionClass(TurnPower.class, TurnPowerResult.class);
        schemaBuilder.addActionClass(SetBrightness.class, SetBrightnessResult.class);
        schemaBuilder.addActionClass(SetColor.class, SetColorResult.class);
        schemaBuilder.addActionClass(SetColorTemperature.class, SetColorTemperatureResult.class);
        builder.addSchema(schemaBuilder.build());
        return builder.build();
    }

}
