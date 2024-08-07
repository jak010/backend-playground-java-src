package avoid_negations;

import common.Microscope;
import common.Result;
import common.Sample;

public class LaboratoryProblem {


    Microscope microscope;

    Result analyze(Sample sample) {
        if (microscope.isInorganic(sample)) { // 이 라인의 부정 조건은 코드 상 이해하기 힘든 표현이다.
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (!microscope.isHumanoid(sample)) { // 이 라인의 부정 조건은 코드 상 이해하기 힘든 표현이다.
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }
}
