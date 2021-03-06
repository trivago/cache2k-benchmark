package org.cache2k.benchmark.thirdparty;

/*
 * #%L
 * thirdparty
 * %%
 * Copyright (C) 2013 - 2016 headissue GmbH, Munich
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.github.benmanes.caffeine.cache.simulator.policy.Policy;
import com.github.benmanes.caffeine.cache.simulator.policy.irr.LirsPolicy;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.cache2k.benchmark.BenchmarkCollection;

/**
 * @author Jens Wilke; created: 2013-06-13
 */
public class CaffeineSimulatorLirsBenchmark extends BenchmarkCollection {

  /**
   * @see <a href="https://github.com/ben-manes/caffeine/blob/master/simulator/src/main/resources/reference.conf"/>
   */
  public final String LIRS_CONFIG =
    "lirs {\n" +
    "  # The percentage for the HOT queue\n" +
    "  percent-hot = \"0.99\"\n" +
    "  # The multiple of the maximum size dedicated to non-resident entries\n" +
    "  non-resident-multiplier = \"2.0\"\n" +
    "  # The percentage of the hottest entries where the stack move is skipped\n" +
    "  percent-fast-path = \"0.0\" # \"0.05\" is reasonable\n" +
    "}\n";

  {
    factory =
      new CaffeineSimulatorCacheFactory()
        .config(ConfigFactory.parseString(LIRS_CONFIG))
        .policy(new CaffeineSimulatorCacheFactory.PolicyFactory() {
          @Override
          public Policy create(final Config _config) {
            return new LirsPolicy(_config);
          }
        });
  }

}
