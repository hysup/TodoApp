package com.teamsparta.springtodo.config.aop


import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Component
@Aspect
class StopWatchAspect {

    private val logger = org.slf4j.LoggerFactory.getLogger("Execution Time Logger")

    @Around("@annotation(com.teamsparta.springtodo.config.aop.StopWatch)")
    fun run(joinPoint: ProceedingJoinPoint) {
        val stopWatch = StopWatch()

        stopWatch.start()
        joinPoint.proceed()
        stopWatch.stop()

        val methodName = joinPoint.signature.name
        val methodArgument = joinPoint.args

        val timeElapsedMs = stopWatch.totalTimeMillis
        logger.info("Execution Time : $timeElapsedMs")
    }
}