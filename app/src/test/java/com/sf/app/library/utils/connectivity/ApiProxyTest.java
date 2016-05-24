package com.sf.app.library.utils.connectivity;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ApiProxyTest {

    @Test
    public void should_is_single_ton() {
        // given

        // when
        ApiProxy apiProxy = ApiProxy.sharedInstance();
        ApiProxy apiProxySingleton = ApiProxy.sharedInstance();

        // then
        assertThat(apiProxy).isNotNull();
        assertThat(apiProxySingleton).isEqualTo(apiProxySingleton);
    }


}