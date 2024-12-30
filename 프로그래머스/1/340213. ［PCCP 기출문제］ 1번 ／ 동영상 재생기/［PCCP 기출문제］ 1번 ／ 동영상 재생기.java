
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] sas = {"next"};
        solution.solution(	"07:22", "04:05", "00:15", "04:07", sas);

    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        if (isOpening(pos, op_start, op_end)) {
            pos = op_end;
        }

        for (String command : commands) {

            if (command.equals("next")) {
                pos = nextCommand(pos, video_len);
            } else if (command.equals("prev")) {
                pos = prevCommand(pos);
            }

            if (isOpening(pos, op_start, op_end)) pos = op_end;
        }

        return pos;
    }

    private boolean isOpening(String pos, String ops, String ope) {
        String[] posSplit = pos.split(":");
        int hour = Integer.parseInt(posSplit[0]);
        int min = Integer.parseInt(posSplit[1]);

        String[] opsSplit = ops.split(":");
        int opsHour = Integer.parseInt(opsSplit[0]);
        int opsMin = Integer.parseInt(opsSplit[1]);

        String[] opeSplit = ope.split(":");
        int opeHour = Integer.parseInt(opeSplit[0]);
        int opeMin = Integer.parseInt(opeSplit[1]);

        
        if (hour >= opsHour && hour <= opeHour) {
            if (hour == opsHour && min < opsMin) {
                return false;
            }

            if (hour == opeHour && min > opeMin) {
                return false;
            }

            return true;
        }

        return false;
    }

    private String nextCommand(String pos, String video_len) {
        String[] posSplit = pos.split(":");
        int hour = Integer.parseInt(posSplit[0]);
        int min = Integer.parseInt(posSplit[1]);

        min += 10;
        if (min >= 60) {
            hour += 1;
            min -= 60;
        }

        String[] videoLen = video_len.split(":");
        int lastHour = Integer.parseInt(videoLen[0]);
        int lastMin = Integer.parseInt(videoLen[1]);

        if (hour >= lastHour && min >= lastMin) {
            return video_len;
        }

        return ret(hour, min);
    }

    private String prevCommand(String pos) {
        String[] posSplit = pos.split(":");
        int hour = Integer.parseInt(posSplit[0]);
        int min = Integer.parseInt(posSplit[1]);

        min -= 10;
        if (min < 0) {
            hour -= 1;
            min += 60;
        }

        if (hour < 0) {
            return "00:00";
        }

        return ret(hour, min);
    }

    private String ret(int hour, int min) {
        String retHour = String.valueOf(hour);
        if (retHour.length() == 1) {
            retHour = "0" + retHour;
        }
        String retMin = String.valueOf(min);
        if (retMin.length() == 1) {
            retMin = "0" + retMin;
        }

        return retHour + ":" + retMin;
    }

}
