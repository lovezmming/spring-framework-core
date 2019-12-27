package com.spring.framework.common.base.util;

import com.spring.framework.common.base.enums.ErrorCodeEnum;
import com.spring.framework.common.base.enums.ServiceIdEnum;
import com.spring.framework.common.base.exceptions.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.net.InetAddress;

public class PrimaryKeyUtil {

    private static final Logger logger = LoggerFactory.getLogger(PrimaryKeyUtil.class);

    private static long lastNextIdTime = -1L;

    private static long sequence = 0L;

    /** 序列在id中占的位数 */
    private static final long sequenceBits = 12L;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private static final long sequenceMask = ~(-1L << sequenceBits);

    /** 开始时间截 (2015-01-01) */
    private static final long twepoch = 1420041600000L;

    /** 机器id所占的位数 */
    private static final long workerIdBits = 5L;

    /** 数据标识id所占的位数 */
    private static final long datacenterIdBits = 5L;

    /** 时间截向左移22位(5+5+12) */
    private static final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /** 数据标识id向左移17位(12+5) */
    private static final long datacenterIdShift = sequenceBits + workerIdBits;

    private static long workKey;

    @PostConstruct
    public synchronized void initLocalWorkKey() {
        try {
            byte[] bytes = InetAddress.getLocalHost().getAddress();
            workKey = 0x000000FF &bytes[bytes.length - 1];
        } catch (Exception e) {
            logger.error("机器码初始化异常:{}, 默认值：1L", e.getMessage());
            workKey = 1L;
        }
    }

    /**
     * 获取下一个主键ID
     * @param serviceId 服务ID
     * @return
     */
    public synchronized static String nextId(ServiceIdEnum serviceId, Boolean secret) {
        Long now = System.currentTimeMillis();
        if (now < lastNextIdTime) {
            throw new BusinessException(ErrorCodeEnum.DB_ERROR_1001, "主键生成时间回滚！");
        } else if (now == lastNextIdTime) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                now = System.currentTimeMillis();
            }
        } else {
            sequence = 0L;
        }
        lastNextIdTime = now;
        // 0 0000 0000 0000 0000 0000
        long newId = ((now - twepoch) << timestampLeftShift)
                    | serviceId.getCode() << datacenterIdShift
                    | workKey << datacenterIdBits
                    | sequence;
        return new StringBuilder(secret ? "1": "0").append(serviceId.getKey()).append(String.valueOf(newId)).toString();
    }

    public static String primaryPassword(String password) throws Exception {
        return MD5Util.getMD5String(password, null);
    }

    public static void main(String[] args) {
        // 1 0165 8711 5571 0197 7619
        PrimaryKeyUtil s = new PrimaryKeyUtil();
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - 1420041600000L);
        System.out.println(String.valueOf(123 | 567));
        for (int i = 0; i< 20 ; i++) {
            System.out.println(s.nextId(ServiceIdEnum.USER, Boolean.TRUE));
        }
    }
}
