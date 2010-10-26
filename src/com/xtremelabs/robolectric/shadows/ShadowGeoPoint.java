package com.xtremelabs.robolectric.shadows;

import com.google.android.maps.GeoPoint;
import com.xtremelabs.robolectric.ProxyDelegatingHandler;
import com.xtremelabs.robolectric.util.Implementation;
import com.xtremelabs.robolectric.util.Implements;
import com.xtremelabs.robolectric.util.ShadowWrangler;

import static com.xtremelabs.robolectric.shadows.ShadowMapView.fromE6;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(GeoPoint.class)
public class ShadowGeoPoint {
    @ShadowWrangler private ProxyDelegatingHandler proxyDelegatingHandler;
    public int lat;
    public int lng;

    public void __constructor__(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Implementation
    public int getLatitudeE6() {
        return lat;
    }

    @Implementation
    public int getLongitudeE6() {
        return lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        ShadowGeoPoint that = (ShadowGeoPoint) proxyDelegatingHandler.shadowOf(o);

        if (lat != that.lat) return false;
        if (lng != that.lng) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lat;
        result = 31 * result + lng;
        return result;
    }

    @Override public String toString() {
        return "ShadowGeoPoint{" +
                "lat=" + fromE6(lat) +
                ", lng=" + fromE6(lng) +
                '}';
    }
}
