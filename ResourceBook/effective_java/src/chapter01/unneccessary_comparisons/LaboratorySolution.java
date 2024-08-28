package chapter01.unneccessary_comparisons;

import chapter01.common.Microscope;
import chapter01.common.Result;
import chapter01.common.Sample;

public class LaboratorySolution {

    Microscope microscope;

    Result analyze(Sample sample) {
        if (microscope.isInorganic(sample)) {
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (!microscope.isHumanoid(sample)) {
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }

}
