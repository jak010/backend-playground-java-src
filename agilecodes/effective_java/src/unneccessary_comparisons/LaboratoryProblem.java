package unneccessary_comparisons;


import common.Microscope;
import common.Result;
import common.Sample;

/**
 * Effective Java - 33 page, 쓸모없는 비교 피하기
 */
public class LaboratoryProblem {


    Microscope microscope;

    Result analyze(Sample sample) {
        if (microscope.isInorganic(sample) == true) {
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (microscope.isHumanoid(sample) == false) {
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }
}
