package ke.don.birdie.demo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun FeedbackItemShimmer(
    modifier: Modifier = Modifier,
) {
    OutlinedCard(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Profile header row
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Avatar placeholder
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .shimmerBackground(),
                )

                Spacer(Modifier.width(12.dp))

                // Name placeholder
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .shimmerBackground(),
                )

                Spacer(Modifier.weight(1f))

                // Status chip placeholder
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerBackground(),
                )
            }

            // Rating row placeholder
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(5) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .shimmerBackground(),
                    )
                }
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .width(80.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .shimmerBackground(),
                )
            }

            // Target label placeholder
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .width(60.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .shimmerBackground(),
            )

            // Feedback text placeholder (multiple lines)
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .height(14.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(4.dp))
                            .shimmerBackground(),
                    )
                }
                // Shorter last line
                Box(
                    modifier = Modifier
                        .height(14.dp)
                        .fillMaxWidth(0.6f)
                        .clip(RoundedCornerShape(4.dp))
                        .shimmerBackground(),
                )
            }
        }
    }
}
