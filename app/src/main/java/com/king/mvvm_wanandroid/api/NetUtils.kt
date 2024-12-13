package com.king.mvvm_wanandroid.api


//suspend fun <T : Any> handleResponse(
//    response: WanJetpackResponse<T>
//) {
//    if (response.errorCode == 0) {
//        return response.data
//    } else {
//        return response.errorMsg
//    }
//}

fun <T : Any> handleFlowResponse(response: WanJetpackResponse<T>): T? {
    return if (response.errorCode == 0) {
        response.data
    } else {
        null
    }
}