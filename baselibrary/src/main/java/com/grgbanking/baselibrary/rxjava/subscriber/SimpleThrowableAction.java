/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grgbanking.baselibrary.rxjava.subscriber;


import com.grgbanking.baselibrary.rxjava.logs.RxLog;

import io.reactivex.functions.Consumer;


/**
 * 简单的出错处理（把错误打印出来）
 *
 * @author xuexiang
 * @since 2018/6/10 下午9:26
 */
public final class SimpleThrowableAction implements Consumer<Throwable> {

    private String mTag;

    public SimpleThrowableAction(String tag) {
        mTag = tag;
    }

    @Override
    public void accept(Throwable throwable) throws Exception {
        RxLog.eTag(mTag, "订阅发生错误！", throwable);
    }
}
