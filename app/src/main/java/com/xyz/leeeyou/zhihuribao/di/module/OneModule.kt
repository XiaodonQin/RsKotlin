package com.xyz.leeeyou.zhihuribao.di.module

import com.xyz.leeeyou.zhihuribao.data.model.one.ID
import com.xyz.leeeyou.zhihuribao.data.model.one.Index
import com.xyz.leeeyou.zhihuribao.data.service.OneService
import com.xyz.leeeyou.zhihuribao.data.service.ServiceFactory
import dagger.Module
import dagger.Provides
import rx.Observable
import javax.inject.Singleton

/**
 * ClassName:   OneModule
 * Description:  
 * 
 * Author:      leeeyou                             
 * Date:        2018/2/24 15:16                     
 */
@Singleton
@Module
class OneModule {
    private val endPoint = "http://v3.wufazhuce.com:8000"

    var id: Int = 0

    constructor(id: Int) {
        this.id = id
    }

    constructor()

    @Singleton
    @Provides
    fun provideOne(): Observable<Index> {
        return ServiceFactory.Companion
                .createRxRetrofitService(OneService::class.java, endPoint)
                .getIndexList(id)
    }

    @Singleton
    @Provides
    fun provideIdList(): Observable<ID> {
        return ServiceFactory.Companion
                .createRxRetrofitService(OneService::class.java, endPoint)
                .getIdList()
    }

}