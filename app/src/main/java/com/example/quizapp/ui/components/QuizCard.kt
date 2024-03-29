package com.example.quizapp.ui.components
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.example.quizapp.models.Category
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage


@Composable
fun QuizCard(category: Category, onQuizClicked: (category: Category) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onQuizClicked(category) }),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))

            if (category.iconLink != null) {
                AsyncImage(
                    model = category.iconLink,
                    contentDescription = category.desc,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            } else {
                Spacer(modifier = Modifier.size(80.dp))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = category.title,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = category.desc,
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                )
            }
        }
    }
}
