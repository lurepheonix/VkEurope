package net.lurepheonix.vkeurope;

import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class Main implements IXposedHookZygoteInit, IXposedHookInitPackageResources {
    private static String MODULE_PATH = null;

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        MODULE_PATH = startupParam.modulePath;
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
        if (!resparam.packageName.equals("com.vkontakte.android"))
            return;

        XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "ic_ab_app", modRes.fwd(R.drawable.ic_ab_app));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "icon", modRes.fwd(R.drawable.icon));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "login_logo", modRes.fwd(R.drawable.login_logo));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "audio_seeker_down", modRes.fwd(R.drawable.audio_seeker_down));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "audio_seeker_up", modRes.fwd(R.drawable.audio_seeker_up));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "audio_slider_down", modRes.fwd(R.drawable.audio_slider_down));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "audio_slider_up", modRes.fwd(R.drawable.audio_slider_up));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "audio_slider_focused", modRes.fwd(R.drawable.audio_slider_focused));
        resparam.res.setReplacement("com.vkontakte.android", "drawable", "progress_player", modRes.fwd(R.drawable.progress_player));
    }
}
