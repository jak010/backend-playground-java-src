package chapter01.avoid_negations;

import chapter01.common.Microscope;
import chapter01.common.Result;
import chapter01.common.Sample;

/**
 * 부정 피하기 - 36page
 */
public class LaboratorySolution {

    Microscope microscope;

    Result analyze(Sample sample) {
        if (microscope.isOrganic(sample)) {
            return analyzeOrganic(sample);
        } else {
            return Result.INORGANIC;
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (microscope.isHumanoid(sample)) {
            return Result.HUMANOID;
        } else {
            return Result.ALIEN;
        }
    }

}
