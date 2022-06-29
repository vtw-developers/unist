package com.vtw.dna.unist.shell;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

/**
 * Spring Shell 구동 오류 수정을 위한 클래스
 */
@Service("shellConversionService")
public class ShellConversionService extends DefaultConversionService {
}
