
package eu.rurarz.samsungrs.myveryfirstandroidapp;

import android.accounts.AccountsException;

import eu.rurarz.samsungrs.myveryfirstandroidapp.authenticator.ApiKeyProvider;
import eu.rurarz.samsungrs.myveryfirstandroidapp.core.BootstrapService;
import eu.rurarz.samsungrs.myveryfirstandroidapp.core.UserAgentProvider;
import com.google.inject.Inject;

import java.io.IOException;

/**
 * Provider for a {@link eu.rurarz.samsungrs.myveryfirstandroidapp.core.BootstrapService} instance
 */
public class BootstrapServiceProvider {

    @Inject private ApiKeyProvider keyProvider;
    @Inject private UserAgentProvider userAgentProvider;

    /**
     * Get service for configured key provider
     * <p>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws IOException
     * @throws AccountsException
     */
    public BootstrapService getService() throws IOException, AccountsException {
        return new BootstrapService(keyProvider.getAuthKey(), userAgentProvider);
    }
}
