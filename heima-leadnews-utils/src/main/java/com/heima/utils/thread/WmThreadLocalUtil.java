package com.heima.utils.thread;

import com.heima.model.wemedia.pojos.WmUser;

/**
 * ClassName: WmThreadLocalUtil
 * Package: com.heima.utils.common.thread
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/28 17:21
 * @Version 1.0
 */
public class WmThreadLocalUtil {
    private final static ThreadLocal<WmUser> WM_USER_THREAD_LOCAL = new ThreadLocal<>();

    //存入线程中
    public static void setUser(WmUser wmUser) {
        WM_USER_THREAD_LOCAL.set(wmUser);
    }

    //从线程中读取
    public static WmUser getUser() {
        return WM_USER_THREAD_LOCAL.get();
    }

    //清理
    public static void clear() {
        WM_USER_THREAD_LOCAL.remove();
    }
}
